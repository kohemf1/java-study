package exam;

public class Person {

	String personName = "";
	String personPhone = "000-0000-0000";
	String personRegNum = "000000-0000000";

	public static void main(String[] args) {

		Person per = new Person();
		per.personName = "이재훈";
		per.personPhone = "010-1234-5678";
		per.personRegNum = "123456-1234567";		
		System.out.println(per.personName + "\n"  + per.personPhone + "\n" + per.personRegNum );

		Person per2 = new Person();
		per2.personName = "홍길동";
		per2.personPhone = "010-5678-5789";
		per2.personRegNum = "111111-1111111";
		System.out.println(per2.personName + "\n"  + per2.personPhone + "\n" + per2.personRegNum );
	}
}
