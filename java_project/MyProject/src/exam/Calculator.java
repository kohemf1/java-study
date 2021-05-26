package exam;

public class Calculator{
	
		// 메소드 -> 기능 ( 재료 -> 처리 -> 반환 )
		// 반환타입 메소드이름(매개변수들){ 처리 구문 }
	
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
		System.out.println(cal.add(3, 5));
		System.out.println(cal.mul(3, 5));
		System.out.println(cal.sub(5, 3));
	}

}
