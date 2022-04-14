import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * FetchAndStore class defines the components to fetching an information from URL and copy it to file
 * @author GotaMitamura
 * @version 1.0
 */
public class FetchAndStore {
	//This program uses a scanner a few times so prepare it as a constant variable
	static final Scanner scan = new Scanner(System.in);
	public static void main (String[] args) throws IOException {
		//main routine prepare input and output stream and accept input from user, finally calling copyStream method
		InputStream in = null;
		OutputStream out = null;
		
		//Get an input of URL from user and convert it into InputStream data
		System.out.println("Type URL. Note: Your input must be a complete URL, beginning with http://");
		String urlString = scan.next();
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e1) {
			// TODO
			e1.printStackTrace();
		}
		try {
			in = url.openStream();
		} catch (IOException e) {
			// TODO 
			e.printStackTrace();
		}
		
		//Get an input of Filename from user and convert it into OutputStream data		
		System.out.println("Type Filename.");
		String fileName = scan.next();
		scan.close();
		try {
			out = new FileOutputStream(fileName);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		//Call copyStream method to copy data from Web URL to file created
		try {
			copyStream(in, out);
		} catch (IOException e) {
			// TODO 
			e.printStackTrace();
		}finally {
			//Close streams opened above
			in.close();
			out.close();
		}
		System.out.println("This is the end of program!");
	}
	private static void copyStream(InputStream in, OutputStream out) throws IOException {
		//copyStream copy a data from InputStream to OutputStream
		int oneByte = in.read();
		while (oneByte >= 0) { // negative value indicates end-of-stream
			out.write(oneByte);
			oneByte = in.read();
		}
	}
}