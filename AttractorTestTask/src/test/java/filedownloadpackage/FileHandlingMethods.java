package filedownloadpackage;

import java.io.*;
import java.net.*;
import java.nio.channels.*;

import org.testng.Assert;

/**
 * File handling methods for code reuse
 */
public class FileHandlingMethods {

	/**
	 * Download file given name and URL
	 * 
	 * @param url			URL to download file
	 * @param filename		Name of the file to be downloaded
	 */
	public static void downloadFileFromURL(String url, String filename) {
		try {
			// Use transferFrom() method from the ReadableByteChannel class to download the bytes from the given URL 
			// that will be transferred to a FileChannel corresponding to the file that will be downloaded
			// and save it in src\test\resources folder
			URL downloadURL = new URL(url);
			InputStream is = downloadURL.openStream();
			ReadableByteChannel rbc = Channels.newChannel(is);
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\" + filename);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			is.close();
			fos.close();
			rbc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verify the file contains a certain string
	 * 
	 * @param filename			Name of the file
	 * @param expectedString	Expected string to be verified
	 */
	public static void verifyFileContainsString(String filename, String expectedString) {
		try {
			InputStream is = FileDownloadTest.class.getClassLoader().getResourceAsStream(filename);
			StringBuilder actualContent = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        String line;
	        while ((line = br.readLine()) != null) {
	        	actualContent.append(line).append("\n");
	        }
	        is.close();
	        br.close();
	        Assert.assertTrue(actualContent.toString().contains(expectedString));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
