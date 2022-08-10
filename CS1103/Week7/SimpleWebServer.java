import java.io.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author gomitamu
 * @version 1.0
 *          SimpleWebServer class accepts a GET request from clients and read a
 *          data of the file and write it back to user.
 *          This class only accepts a GET method and returns various errors if a
 *          request did not meet the requirement.
 */

public class SimpleWebServer {
	private final static int LISTENING_PORT = 50501; // Port has to be released when this line is called.
	private final static String ROOT_DIRECTORY = System.getProperty("user.dir"); // Get an information of root dir of the
																																								// user who executed this server.

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket; // Prepare serverSocket to make web server work
		Socket connection; // Prepare socket to use a communication between servers
		try {
			serverSocket = new ServerSocket(LISTENING_PORT); // ServerSocket will create new socket with port number that is
																												// given
		} catch (Exception e) {
			System.out.println("Failed to create listening socket.");
			return;
		}
		System.out.println("Listening on port " + LISTENING_PORT);
		try {
			while (true) {
				connection = serverSocket.accept(); // Here is the connection that is created to accept a request from clients
				System.out.println("\nConnection from "
						+ connection.getRemoteSocketAddress());
				ConnectionThread thread = new ConnectionThread(connection);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println("Server socket shut down unexpectedly!");
			System.out.println("Error: " + e);
			System.out.println("Exiting.");
		}
		try {
			serverSocket.close();
		} catch (Exception e) {
			System.out.println("serverSocket Connection failed to be closed.");
		}
	}

	private static void handleConnection(Socket connection) {
		try {
			Scanner in = new Scanner(connection.getInputStream());
			PrintWriter pw = new PrintWriter(connection.getOutputStream());
			OutputStream out = connection.getOutputStream();
			String line = in.nextLine();
			String[] threeTokens = line.split("\\s+"); // Split the first line with blank space into three tokens.
			File filepath = new File(ROOT_DIRECTORY + threeTokens[1]);
			// Here are the patterns for error handling.
			if (!threeTokens[0].equals("GET")) {
				System.out.println("You need to use GET method.");
				sendErrorResponse(501, out);
			} else if (!threeTokens[2].equals("HTTP/1.0") && !threeTokens[2].equals("HTTP/1.1")) {
				System.out.println("You use a wrong protocol.");
				sendErrorResponse(400, out);
			} else if (!filepath.exists()) {
				System.out.println("The file is not found.");
				sendErrorResponse(404, out);
			} else if (!filepath.canRead()) {
				System.out.println("The file is not allowed to access.");
				sendErrorResponse(403, out);

				// The part to process files
			} else if (filepath.exists() && filepath.canRead() && !filepath.isDirectory()) { // Check if the file exists with
																																												// readable format, not a
																																												// directory.
				pw.println(threeTokens[2] + " 200" + " OK" + "\r\n");// Not sure why my browser does not give this line unless I
																															// give the same code. I tried with "\r\n" but it did not
																															// work.
				pw.println(threeTokens[2] + " 200" + " OK" + "\r\n");// Print out status line, connection closed status,
																															// content-type and content-length before the file
																															// contents
				pw.println("Connection: close" + "\r\n");//
				pw.println("Content-type: " + getMimeType(threeTokens[1]) + "\r\n");
				pw.println("Content-Length: " + filepath.length() + "\r\n");
				pw.println("\r\n");
				pw.flush();
				sendFile(filepath, out);
			} else if (filepath.exists() && filepath.isDirectory()) { // This is the case to treat an index.html when file
																																// path given was a directory that exists.
				File indexPagePath = new File(filepath + "/index.html");
				if (indexPagePath.exists()) {
					pw.println(threeTokens[2] + "index.html" + " 200" + " OK" + "\r\n");// Not sure why my browser does not give
																																							// this line unless I give the same code.
																																							// I tried with "\r\n" but it did not work
					pw.println(threeTokens[2] + "index.html" + " 200" + " OK" + "\r\n");// Print out status line, connection
																																							// closed status, content-type and
																																							// content-length before the file contents
					pw.println("Connection: close" + "\r\n");//
					pw.println("Content-type: " + "text/html" + "\r\n");
					pw.println("Content-Length: " + indexPagePath.length() + "\r\n");
					pw.println("\r\n");
					pw.flush();
					sendFile(indexPagePath, out);
				}
			} else {
				System.out.println("Something wrong happens with server. Please contact to the admin of server.");
				sendErrorResponse(500, out);
			}
		} catch (Exception e) {
			System.out.println("Error while communicating with client: " + e);
		} finally { // make SURE connection is closed before returning!
			try {
				connection.close();
			} catch (Exception e) {
			}
			System.out.println("Connection closed.");
		}

	}

	private static String getMimeType(String fileName) {
		int pos = fileName.lastIndexOf('.');
		if (pos < 0) // no file extension in name
			return "x-application/x-unknown";
		String ext = fileName.substring(pos + 1).toLowerCase();
		if (ext.equals("txt"))
			return "text/plain";
		else if (ext.equals("html"))
			return "text/html";
		else if (ext.equals("htm"))
			return "text/html";
		else if (ext.equals("css"))
			return "text/css";
		else if (ext.equals("js"))
			return "text/javascript";
		else if (ext.equals("java"))
			return "text/x-java";
		else if (ext.equals("jpeg"))
			return "image/jpeg";
		else if (ext.equals("jpg"))
			return "image/jpeg";
		else if (ext.equals("png"))
			return "image/png";
		else if (ext.equals("gif"))
			return "image/gif";
		else if (ext.equals("ico"))
			return "image/x-icon";
		else if (ext.equals("class"))
			return "application/java-vm";
		else if (ext.equals("jar"))
			return "application/java-archive";
		else if (ext.equals("zip"))
			return "application/zip";
		else if (ext.equals("xml"))
			return "application/xml";
		else if (ext.equals("xhtml"))
			return "application/xhtml+xml";
		else
			return "x-application/x-unknown";
		// Note: x-application/x-unknown is something made up;
		// it will probably make the browser offer to save the file.
	}

	private static void sendFile(File file, OutputStream socketOut) throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		OutputStream out = new BufferedOutputStream(socketOut);
		while (true) {
			int x = in.read(); // read one byte from file
			if (x < 0)
				break; // end of file reached
			out.write(x); // write the byte to the socket
		}
		in.close();
		out.flush();
	}

	private static class ConnectionThread extends Thread {
		Socket connection;

		ConnectionThread(Socket connection) {
			this.connection = connection;
		}

		public void run() {
			handleConnection(connection);
		}
	}

	static void sendErrorResponse(int errorCode, OutputStream socketOut) {
		// In order to let users know the status on browser, print writer should write
		// an information to output stream, not just print out to console.
		PrintWriter pw = new PrintWriter(socketOut);
		switch (errorCode) {
			case 400:
				pw.println("HTTP/1.1 400 Bad Request");
				break;
			case 403:
				pw.println("HTTP/1.1 403 Forbidden");
				break;
			case 404:
				pw.println("HTTP/1.1 404 Not Found");
				break;
			case 500:
				pw.println("HTTP/1.1 500 Internal Server Error");
				break;
			case 501:
				pw.println("HTTP/1.1 501 Not Implemented");
				break;
		}
		pw.flush();
	}
}
