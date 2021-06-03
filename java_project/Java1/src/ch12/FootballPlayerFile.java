package ch12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FootballPlayerFile {

	public static void main(String[] args) {
		
		//②이 인스턴스 들을 파일로 저장하는 기능을 만들어 봅시다.
		//③저장된 파일을 객체로 만드는 기능을 만들어봅시다.
		
		File player = new File("c:\\JavaEx");
		
		try {
			BufferedWriter wPlayer = new BufferedWriter(new FileWriter("c:\\JavaEx\\playerList.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
