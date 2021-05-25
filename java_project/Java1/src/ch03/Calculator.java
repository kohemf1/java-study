package ch03;

import java.util.*;

public class Calculator {

	 int add(int a, int b) { return a+b; }
	 int sub(int a, int b) { return a-b; }
	 int mul(int a, int b) { return a*b; }
	 float div(int a, int b) { return (float)a/b; }
	 float cif (int r) { return (float)( 2*Math.PI*r);}
	 float ext (int r) { return (float)( Math.PI*r*r);}

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력해주세요.");
		int a = sc.nextInt();
		System.out.println("두번째 숫자를 입력해주세요.");
		int b = sc.nextInt();
		System.out.println("반지름을 입력해주세요.");
		int r = sc.nextInt();
		System.out.println("더하기 : " + cal.add(a,b));
		System.out.println("빼기 : " + cal.sub(a,b));
		System.out.println("곱하기 : " + cal.mul(a,b));
		System.out.println("나누기 : " + cal.div(a,b));
		System.out.println("원의 둘레 : " + cal.cif(r));
		System.out.println("원의 넓이 : " + cal.ext(r));
			
	}
}
