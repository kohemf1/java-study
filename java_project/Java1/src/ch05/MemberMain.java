package ch05;

public class MemberMain {

	public static void main(String[] args) {
		MemberAns member1 = new MemberAns(
				"철수", 
				"010-1234-5678",
				"음악", 
				4, 
				"naver@gmail.com",
				"1999-09-09","서울");
		
		//member1.Name1="영희";
		member1.setName1("영희");
		member1.showInfo();
		System.out.println(member1.getName1());
		
	}
}