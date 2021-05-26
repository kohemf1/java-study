package ch07;

public class Female extends Person {
	
	String major;
	String color;
	
//	public Female(String name, String perNum, int age, String major, String color) {
//		super(name, perNum, age);
//		this.major = major;
//		this.color = color;
//	}
	
	public Female(String name, long perNum,  String major, String color) {
		super(name, perNum);
		this.major = major;
		this.color = color;
	}

	void hello() {
		super.hello();
		System.out.println( color +"을 좋아합니다.");
	}
	
	void studying() {
		System.out.println( major + "를 공부합니다.");
		System.out.println();
	}
	
}
