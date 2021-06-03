package practice060321;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class TextBook {

	public static void main(String[] args) {
		//1.콘솔기반으로 메모장 기능을 만들어 봅시다.
		//①File 클래스를 이용해서 저장 폴더 생성


		File reDir = new File("C:\\JavaEx");
		reDir.mkdir();

		System.out.println("1번 메모쓰기  \n"+ "2번 메모읽기 \n"+ "3번 리스트");

		//②문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장

		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int date = now.get(Calendar.DATE);

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a == 1) {
			System.out.println("title 입력");
			String tit = sc.nextLine();
			System.out.println("내용 입력 ( 00 을 치면 종료)");

			String memo = sc.nextLine();

			//③파일의 이름은 날짜와 메모의 제목을 이용해서 생성		
			try {
				BufferedWriter out = 
						new BufferedWriter(new FileWriter
								("C:\\JavaEx\\"+year+"년"+month+"월"+date+"일"+tit+".txt"));			
				out.write(memo);
				out.newLine();
				out.write(year+ "." + month +"."+ date);			
				out.close();
				System.out.println("메모 종료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (a == 3) {
			//④메모리스트와 파일 읽기 기능을 구현해봅시다.
			File dir = new File("C:\\JavaEx\\");
			File lists[] = dir.listFiles();
			for(int i=0; i<lists.length; i++) {
				System.out.println(lists[i]);			
			}		
		}//else if (a == 2) {

			//BufferedReader in = new BufferedReader(new FileReader);

		//}

	}

}


