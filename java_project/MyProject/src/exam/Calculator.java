package exam;

public class Calculator{

	int a;
	int b;

	int add (int a , int b) {
		return a + b;
	}
	int sub (int a , int b) {
		return a - b;
	}
	int mul (int a , int b) {
		return a*b;
	}
	double div (int a , int b) {
		return (double) a / b;
	}

	public static void main(String[] args) {
		
		// 인스턴스 생성 -> 클래스의 정의가 필요 ( 필요한 변수 , 필요한 메소드)
		// 클래스이름 참조변수 = new 클래스이름
		
		Calculator cal = new Calculator();
		
		System.out.println(cal.div(3, 5));
		
	}
	
	


}
