package ch13;

import java.util.Scanner;

public class HighLowGame {

	public static void main(String[] args) {
		//①1~100 사이의 랜덤 한 숫자를 추출합니다.
		
		int a = (int)(Math.random()*100)+1;
		
		System.out.println("하이 로우 게임");
		//②사용자에게 숫자를 입력 받고, 랜덤 숫자와 비교하고, 높은 숫자인지 낮은 숫자인지 출력
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("숫자를 입력해주세요");
			int b = sc.nextInt();
			if(a > b) {
				System.out.println("랜덤 숫자가 더 큽니다.");
			}else if ( a < b){
				System.out.println("랜덤 숫자가 더 작습니다");
			}else {
				System.out.println("정답입니다.");
				break;	
			}
		}
		//③10초 카운팅은 스레드를 이용해서 처리해봅시다.

		//④10초 이전에 맞추면 미션 성공, 10초가 지나면 프로그램 종료하는 흐름으로 만들어봅시다.

	}

}

//class InputTh extends Thread{
//	public void run() {
//		int num = JOptionpane.
//	}
//}
