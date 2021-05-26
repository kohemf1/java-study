package ch07;

public class Person {
	String name;
	String perNum;
	int age;
	
	public Person(String name, String perNum, int age ){
		this.perNum = perNum;
		this.name = name;
		this.age = age;	
	}
	
	void hello() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다." + this.age +"살이에요.");

	}
	
		
}
