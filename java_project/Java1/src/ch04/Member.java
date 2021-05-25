package ch04;

import java.util.Scanner;

public class Member {

	int thisYear = 2021;
	int birth;
	int age(int birth) { return thisYear - birth;}

	void vaccine(int birth) {		
		if(age(birth) < 15 || age(birth)>65) {
			System.out.println("예방접종 대상자입니다.");
		}else {
			System.out.println("예방접종 무료 대상자가 아닙니다.");
		}
	}

	void medicalEx(int birth) {
		if(age(birth) >= 20 && age(birth)%2 == 1) {
			System.out.println("당신은 올해 건강검진 대상자입니다.");
			if ( age(birth) >= 40) {
				System.out.println("당신은 암검사 대상자입니다.");
			} 
		} else {
			System.out.println("대상자가아닙니다.");
		}
	}	
	public static void main(String[] args) {

		Member m = new Member();
		System.out.println("태어난 해를 입력해주세요 .");
		Scanner sc = new Scanner(System.in);				
		int a = sc.nextInt();
		m.vaccine(a);
		m.medicalEx(a);

	}
}
