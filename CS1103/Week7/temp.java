
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Simple web server test to show the ability of java to receive requests and
 * send response when needed.
 * we used a multi-threaded way to listen to more than 1 request at a time.
 * ALso we handles all type of errors in here before sending the response.
 *
 * @author Anonymous (because we can't reveal our names in this type of
 *         assignments)
 *
 */
public class temp {

  /**
   * The server listens on this port. Note that the port number must
   * be greater than 1024 and lest than 65535.
   */
  private final static int LISTENING_PORT = 50507;

  /**
   * The root directory for the web server, you should have all the server files
   * in there.
   * Create it if you don't have that directory structure.
   */
  static String rootDirectory = System.getProperty("user.dir");;

  public static void main(String[] args) {
    ServerSocket serverSocket;
    try {
      serverSocket = new ServerSocket(LISTENING_PORT);
    } catch (Exception e) {
      System.out.println("Failed to create listening socket.");
      return;
    }
    System.out.println("Listening on port " + LISTENING_PORT);
    try {
      while (true) {
        Socket connection = serverSocket.accept();
        System.out.println("\nConnection from "
            + connection.getRemoteSocketAddress());
        // handleConnection(connection);
        ConnectionThread thread = new ConnectionThread(connection);
        thread.start();
      }
    } catch (Exception e) {
      System.out.println("Server socket shut down unexpectedly!");
      System.out.println("Error: " + e);
      System.out.println("Exiting.");
    }
  }

  /**
   * Subclass to make our WebServer multi-threaded
   * In there it calls the handleConnection() method instead of calling it
   * directly from the Main().
   */
  private static class ConnectionThread extends Thread {
    Socket connection;

    ConnectionThread(Socket connection) {
      this.connection = connection;
    }

    public void run() {
      handleConnection(connection);
    }
  }

  /**
   * To handle the connection that are in-going and out-going and respond
   * accordingly
   * It also handles all the possible errors might happened.
   *
   * @param connection: The socket.
   */
  private static void handleConnection(Socket connection) {

    try {
      Scanner in = new Scanner(connection.getInputStream());
      PrintWriter respond = new PrintWriter(connection.getOutputStream());
      OutputStream out = connection.getOutputStream();

      String token1 = in.next();
      String token2 = in.next();
      String token3 = in.next();

      if (!token1.equalsIgnoreCase("GET")) {
        System.out.println("not a get request");
        try {
          sendErrorResponse(501, out);
        } catch (Exception ex) {
          System.out.println("Error while trying to send out an error LOL");
        }

        return;
      }

      if (!token3.equalsIgnoreCase("HTTP/1.1") && !token3.equalsIgnoreCase("HTTP/1.0")) {
        System.out.println("not HTTP/1.1 or HTTP/1.0");
        try {
          sendErrorResponse(400, out);
        } catch (Exception ex) {
          System.out.println("Error while trying to send out an error LOL");
        }

        return;
      }

      File file = new File(rootDirectory + token2);

      if (!file.exists()) {
        System.out.println("file is not existed");
        try {
          sendErrorResponse(404, out);
        } catch (Exception ex) {
          System.out.println("Error while trying to send out an error LOL");
        }
        return;
      }

      if (!file.canRead()) {
        System.out.println("can't read the file due to permession issues");
        try {
          sendErrorResponse(403, out);
        } catch (Exception ex) {
          System.out.println("Error while trying to send out an error LOL");
        }
        return;
      }

      if (!file.isDirectory()) {
        System.out.println("it is a directory not a file.");
        try {
          sendErrorResponse(403, out);
        } catch (Exception ex) {
          System.out.println("Error while trying to send out an error LOL");
        }
        return;
      }

      String status = token3 + " 200 OK\r\n";
      respond.print(status);

      // the connection status
      respond.print("Connection: close\r\n");

      // the Mime type
      String type = getMimeType(file.getName());
      respond.print("Content-Type: " + type + "\r\n");

      // the connection length
      respond.print(file.length());

      // empty line
      respond.print("\r\n");

      respond.flush();
      sendFile(file, out);
    } catch (Exception e) {
      System.out.println("Error while communicating with client: " + e);

      try {
        OutputStream out = connection.getOutputStream();
        sendErrorResponse(500, out);
      } catch (Exception ex) {
        System.out.println("Error while trying to send out an error LOL");
      }

    } finally { // make SURE connection is closed before returning!
      try {
        connection.close();
      } catch (Exception e) {
      }
      System.out.println("Connection closed.");
    }

  }

  /**
   *
   * @param fileName The file that we need to check its Mime
   * @return the Mime of the file.
   */
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

  /**
   * To finally send the file after handling the connection.
   *
   * @param file      The file we need to send out
   * @param socketOut The stream or the socket
   * @throws IOException
   */
  private static void sendFile(File file, OutputStream socketOut) throws IOException {
    InputStream in = new BufferedInputStream(new FileInputStream(file));
    OutputStream out = new BufferedOutputStream(socketOut);
    while (true) {
      int x = in.read(); // read one byte from file
      if (x < 0)
        break; // end of file reached
      out.write(x); // write the byte to the socket
    }
    out.flush();
    in.close();
  }

  /**
   * sending difference type of web errors depending on what we needs.
   *
   * @param errorCode The error code to determine which error we will send
   * @param socketOut The socket stream out we need to send the error in
   */
  static void sendErrorResponse(int errorCode, OutputStream socketOut) {

    String p = "HTTP/1.1";
    String desc = "";
    String mesages = "";

    // I got the message status from the internet, you can add more if you want.
    switch (errorCode) {
      case 400:
        desc += "400 Bad Request";
        mesages += "The syntax of the request is bad.";
        break;
      case 403:
        desc += "403 Forbidden";
        mesages += "The server does not have permission to read the file.";
        break;
      case 404:
        desc += "404 Not Found";
        mesages += "The resource that you requested does not exist on this server.";
        break;
      case 500:
        desc += "500 Internal Server Error";
        mesages += "There has been an error in handling the connection.";
        break;
      case 501:
        desc += "501 Not Implemented";
        mesages += "The command received has not been implemented.";
        break;
      default:
        desc += "500 Internal Server Error";
        mesages += "There has been an error in handling the connection.";
        break;
    }

    try {
      PrintWriter out = new PrintWriter(socketOut);

      out.print(p + desc + "\r\n");
      out.print("Connection: close\r\n");
      out.print("Content-Type: text/html\r\n");
      out.print("\r\n");
      out.print("<html><head><title>Error</title></head><body>\r\n");
      out.print("<h2>Error:" + desc + "</h2>\r\n");
      out.print("<p>" + mesages + "</p>\r\n");
      out.print("</body></html>\r\n");
      out.flush();

      out.close();
    } catch (Exception e) {
      System.out.println("Error occored while proccessing the error method");
    }
  }
}
