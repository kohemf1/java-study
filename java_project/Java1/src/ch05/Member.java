package ch05;

public class Member {

	String name;	
	String phone; 
	String major;
	int grade;
	String email;
	String birth;
	String address;

	Member(String name, String phone, String major, int grade, 
			String email, String birth, String address){
		this.name = name;	
		this.phone = phone;	
		this.grade = grade;
		this.email = email;
		this.major = major;
		this.birth = birth;
		this.address = address;

	}
	Member(String name, String phone, String major, int grade, 
			String email){
		this.name = name;	
		this.phone = phone;	
		this.grade = grade;
		this.email = email;
		this.major = major;
	}

	void info() {
		System.out.println(name + " " + phone + " " + major + " " + grade + "학년 " +
				email +  " " + birth + " " + address);
	}
	public static void main(String[] args) {
		Member m = new Member("길동", "010-1111-1111", "경영", 2, "daue@naver.com", "1999-11-11", "서울");
		m.info();
		Member m1 = new Member("몽룡", "010-5555-5555", "경제", 3, "kakao@daum.net");
		m1.info();
	}
}
