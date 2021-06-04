package ex;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

	public static void main(String[] args) {
		
		
		try {
			
			URL url = new URL("http://www.google.com"); // www.google.com/index.html 찾아가도록 되잇는거
			
			//URLConnection : Url.openConnection()
			URLConnection con = url.openConnection();
			
			InputStream in = con.getInputStream();
			
			int i = 0;
			
			while(i != -1) {
				i = in.read();
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
