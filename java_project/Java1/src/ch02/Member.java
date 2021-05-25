package ch02;

public class Member {
	
	int num;
	//static ->
	public static void main(String[] args) {
		//변수 선언
		//데이터의 타입 식벽 이름
		//데이터 타입 -> 내가 다루어야 하는 데이터의특 징에의해서 결정
		//기본형 타입 8가지 -> 정수형, 실수형 ,bool, 문자
		
		
//		①String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
		String name = "홍길동";
//		②int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
		int age = 25;
//		③double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다.
		//정수는 int 기본 실수는 double이 기본
		double height = 176.1d;
		float weight = 45.8f;
		
//		④boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
		boolean hasBook = false;
//		⑤이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
		System.out.println("저의 이름은 " + name ); //String + String
		System.out.println("키는 " + height + "cm 입니다."); 
		// String + double + String  -> (String + String) + String
		// -> String + String  // String + any Type -> String + String
		System.out.println("제나이는 " + age + "살입니다.");
		System.out.println("책의 보유 여부 : " + hasBook);
		
		if(hasBook) {
			System.out.println("책 있어요");
		}else {
			System.out.println("책 없어요");
		}

	}

}
