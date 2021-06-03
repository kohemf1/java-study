package ch12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

	public static void main(String[] args) {

		File file = new File("C:\\JavaEx\\안녕.txt");		
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bRead = 
					new BufferedReader(filereader);
			String str = null;
			while((str = bRead.readLine()) != null) {
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
