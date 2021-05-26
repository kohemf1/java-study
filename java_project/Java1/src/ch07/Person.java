package ch07;

import java.util.Calendar;

public class Person {
	String name;
//	String perNum;
	long perNum;
//	int age

	
	public Person(String name, long perNum/*, int age*/ ){
		this.perNum = perNum;
		this.name = name;
//		this.age = age;	
	}
	
	void hello() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		long a =  (long) (perNum/10000000d);
		System.out.println(a);
		long b = (long) perNum - (a*10000000);
		System.out.println(b);
		 if(b>=3000000){
			long age = year - (long)(perNum/100000000000d) - 2000 + 1 ;
			System.out.println("안녕하세요. 저는 " + this.name + "입니다." + age +"살이에요.");
		 }else {
			 long age = year - (long)(perNum/100000000000d) - 1900 + 1 ;
			 System.out.println("안녕하세요. 저는 " + this.name + "입니다." + age +"살이에요.");
		 }
	}
	
}

