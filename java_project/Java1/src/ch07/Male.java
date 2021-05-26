package ch07;

public class Male extends Person{
	
	String hobby;
	String major;
	
	
//	public Male(String name, String perNum, int age, String hobby , String major) {
//		super(name, perNum, age);
//		this.hobby = hobby;
//		this.major = major;
//	}

	public Male(String name, long perNum, String hobby , String major) {
		super(name, perNum);
		this.hobby = hobby;
		this.major = major;
	}
		
	void hello() {
//		System.out.println("안녕하세요. 저는 " + name + "입니다." + this.age +  "살이에요.");
		super.hello();
		System.out.println("취미는" + hobby + "입니다.");

	}
	
	void studying() {
		System.out.println( major + "를 공부합니다." );
		System.out.println();
	}
	public static void main(String[] args) {

		
		
	


	}

}
