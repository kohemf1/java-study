package PracticeExam;

import java.util.Scanner;

public class Pra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub




		//		Scanner sc = new Scanner(System.in);

		int num = 0;
		
		num = Integer.parseInt(getUserInput());
		String pw = null;
		switch(num) {
		case 1 :

			 pw = getUserInput();
			
			 switch (num) {
			 case 1 :
				 System.out.println(pw);
			 }
			
			 break;
		case 2 :	
			System.out.println(pw);
			break;
		}
	}

		public static String getUserInput() {
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			return input;
		}
	}

