package ch05;

public class MemberAns {
	
	//생성자 -> 초기화 메소드, 인스턴스를 생성할 때 단 한번! 인스턴스 변수를 초기화 한다.
//	①아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	// -> 데이터를 저장 -> 변수를 이용해서 메모리에 저장한다.
	
	private String name1; // 클래스의 영역에서 정의 -> 인스턴스 변수 , 인스턴스가 생성될때 변수의 메모리 공간이 생성된다. 초기화를 생략.
	private final String phoneNumber1; // 참조형 변수의 기본 값 -> null 
	private String major1;
	private int grade1;
	private String email1;
	private String birthday1; // 2020-10-10
	private	String address1;
	
	// 접근제어 지시자 private을 쓰는 이유
	// 클래스 내부의 멤버들만 참조가 가능하다. : 정보 은닉, 변수의 데이터를 보호  
	
	
//	③모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의    // 생성자는 변수와 메소드 사이에 
	// 생성자의 요구사항 -> 생성자 오버로딩
	//이름이 같은 메소드 정의 -> 오버로딩
	// 생성자의 이름 (매개변수) { 초기화 코드 ..}
	// 생성자의 이름 -> 클래스 이름
	// 생성자는 반드시 하나이상이 있어야 한다.★
	
	MemberAns(String name1 , String phoneNumber1, String major1,
			int grade1, String email1, String birthday1, String address1 ){
	
		this.name1 = name1;	this.phoneNumber1 = phoneNumber1;
		this.major1 = major1;	this.grade1 = grade1;	this.email1 = email1;
		this.birthday1 = birthday1;	this.address1 = address1;
		
	}
	
	//오버로딩의 조건 : 1. 메소드의 이름은 같다      
	//            2. 매개변수의 개수가틀리거나, 매개변수의 타입이 달라야 오버로딩이 성립이된다.
	
	
	MemberAns(String name1 , String phoneNumber1, String major1,
			int grade1, String email1){
	
//		this.name1 = name1;	this.phoneNumber1 = phoneNumber1;
//		this.major1 = major1;	this.grade1 = grade1;	this.email1 = email1;
		this(name1, phoneNumber1, major1, grade1, email1, null, null);
	}
	
	MemberAns(String name1 , String phoneNumber1, String major1	){
	
//		this.name1 = name1;	
//		this.phoneNumber1 = phoneNumber1;
//		this.major1 = major1;	
		this(name1, phoneNumber1, major1, 0, null, null, null);
	}	
 	
	MemberAns(){
		this.phoneNumber1 = "010-1234-5678";
	}
	
//	②위에서 정의한 정보를 출력하는 메소드 정의
	// 기능 -> 메소드  반환이 없을때는 void
	void showInfo() {
		System.out.println("이름 : " + this.name1 );// this -> 자기자신의 참조값을 가지는 참조변수 
		System.out.println("전화번호 : " + phoneNumber1);
		System.out.println("전공  : " + major1 );
		System.out.println("학년 : " + grade1);
		System.out.println("이메일 : " + email1);
		
		if(this.birthday1 == null) {
			System.out.println("생일 : 입력된 데이터가 없습니다." );
		}else {
			System.out.println("생일 : " + birthday1);
		}
		
		if(this.address1 != null) {
		System.out.println("주소 : " + address1);
		}else {
			System.out.println("주소 : 입력된 데이터가 없습니다.");
		}
	}
	
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName1() {
		return this.name1;
	}
	
	
//	④main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
	
	public static void main(String[] args) {
		
		MemberAns member1 = new MemberAns("철수", "010-1234-5678", "음악", 4, "naver@gmail.com","1999-09-09","서울");
		member1.name1 = "영희";
		member1.showInfo();
		//number1.phoneNumber1 = "000-0000-0000"; // final 때문에 바꿀수없음. 생성자에서 바꿀수있따
		System.out.println("----------------------------------------------------------");
		MemberAns member2 = new MemberAns("훈이", "010-9876-5432", "체육", 3, "gmail@naver.com");
		member2.showInfo();
		
	}
}