package ch08;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		
		
		Calculator cal = new CalculatorImp();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력");
		long a = sc.nextLong();
		System.out.println("두번째 숫자 입력");
		long b = sc.nextLong();
		System.out.println(cal.add(a, b));
		System.out.println(cal.substract(a, b));
		System.out.println(cal.multiply(a, b));
		System.out.println(cal.divide(a, b));
		
	}

}
