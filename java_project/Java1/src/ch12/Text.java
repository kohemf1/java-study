package ch12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Text {

	public static void main(String[] args) {
		//1.콘솔기반으로 메모장 기능을 만들어 봅시다.
		//①File 클래스를 이용해서 저장 폴더 생성

		File reDir = new File("C:\\JavaEx");
		reDir.mkdir();

		//②문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
		//③파일의 이름은 날짜와 메모의 제목을 이용해서 생성
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) +1;
		int date = now.get(Calendar.DATE);

		//String tit = "안녕";
		//String name = year +"년"+month+"월"+date+"일" + tit;
		try {
			BufferedWriter out = 
					new BufferedWriter(new FileWriter
							("C:\\JavaEx\\안녕.txt"));			
			out.write("안녕");
			out.newLine();
			out.write("반가워");
			out.newLine();
			out.write("나는 커피를 좋아해");
			out.newLine();
			out.write(year+ "." + month +"."+ date);			
			out.close();
			System.out.println("메모 종료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//④메모리스트와
		File dir = new File("C:\\JavaEx\\");
		File lists[] = dir.listFiles();
		for(int i=0; i<lists.length; i++) {
			System.out.println(lists[i]);			
		}	
		//파일 읽기
		//C:\\JavaEx\\"+name+".txt
		

	}

}


