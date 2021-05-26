package ch06;

public class ScoreManagerAns {

	public static void main(String[] args) {
		
	
	
	//배열 -> 변수의 집합 변수를 묶을때 사용. 같은 타입이고 성격이 같은것들을 묶는다.
	// 타입[] 식별자 = new 타입[사이즈 ] //식별자 -> 주소값
	// 배열은 for와 같이 써야한다.
	
//	1.국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 평균 점수를 출력하는 프로그램을 작성해봅시다.
		
		//국어점수 저장 배열 
		int[] korScore  = new int[10]; 
		//영어점수 저장 배열
		int[] engScore = new int[10];
		//수학점수 저장 배열
		int[] mathScore = new int[10];
		
		// 점수 입력
		korScore[0] = 100;	korScore[1] = 10;	korScore[2] = 20;	korScore[3] = 30;	korScore[4] = 40;	
		korScore[5] = 90;	korScore[6] = 80;	korScore[7] = 70;	korScore[8] = 60;	korScore[9] = 50;	
		
		// 점수 모두 출력
		// 배열의 모든 요소를 출력
		// 배열 -> 일괄처리
//		System.out.println(korScore[0]);	System.out.println(korScore[1]);	System.out.println(korScore[2]);
		//반복문을 이용해서 공통된 작업을 처리 -> 일괄처리
		for(int idx = 0; idx < korScore.length; idx++) {
			System.out.println(korScore[idx]);
		}
		
		// 합을 구하고 -> 평균
		// sum = sum + i  -> sum += i
		// 합을 구하기위한 변수 sum 선언
		int sum = 0;
		for(int i = 0; i<korScore.length; i++) {
			sum = sum + korScore[i];
		}
		System.out.println("국어점수의 합 : " + sum);
		
		// 평균 -> 총합/배열의 개수
		float avg = (float)sum/korScore.length;
		System.out.println("국어 점수의 평균 : " + avg);
				

	
	
	}	
}
