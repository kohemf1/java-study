package manager;

import java.util.List;
import java.util.Scanner;

import member.*;

public class MemberManage {
	//메소드
	// 회원 정보 관리
	//25일 : 회원 정보 수정
	private ManagerDao dao;
	private Scanner scan;
		
	public MemberManage(ManagerDao dao) {
		this.dao = dao;
		scan = new Scanner(System.in);
	}	
	
	//회원 가입 메서드
	public void addMember() {
		System.out.println("회원가입을 시작합니다.");
		System.out.println("아이디 비밀번호 이름 운전면허 이메일 주소 형식으로 입력해주세요.");
		System.out.println("에시) hi 1234 홍길동 111111 t@naver.com seoul");
		String inputData = scan.nextLine();
		String[] memberdata = inputData.split(" ");
		
		Member member = new Member(
				0, 
				memberdata[0], 
				memberdata[1], 
				memberdata[2], 
				memberdata[3], 
				memberdata[4],
				memberdata[5]
						);
		
		int result = dao.insertMember(member);
		
		if(result > 0) {
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("입력 실패!!!!");
		}	
	}
	//회원 리스트 출력 메소드 
	//Dao에서 데이터 리스트를 받고 출력 처리
	public void memberList() {
		
		List<Member> list = dao.getMemberList();
		System.out.println("회원의 리스트를 출력합니다.");
		System.out.println("-----------------------------------------------------------");
		System.out.println("membercode \t id \t name \t carreg \t email \t address");
		System.out.println("-----------------------------------------------------------");
		
		for(Member member : list) {
			System.out.printf("%d \t %s \t %s \t %s \t %s \t %s \n ",
					member.getMembercode(),
					member.getId(),
					member.getName(), 
					member.getCarreg(), 
					member.getEmail(), 
					member.getAddress());
		}		
	}
	//member 로그인 메서드
	public boolean memberLogin() {
		boolean result = false;
	System.out.println("아이디를 입력하세요.");
	String id = scan.nextLine();
	System.out.println("비밀번호를 입력하세요.");
	String pw = scan.nextLine();
	if(dao.memberLogin(id, pw) > 0) {
		result = true;
	}else {
		System.out.println("올바른 값을 입력하세요");
		result = false;
	}
			return result;
}
	//manager 로그인 메서드
	public boolean managerLogin() {
		boolean result = false;
	System.out.println("아이디를 입력하세요.");
	String id = scan.nextLine();
	System.out.println("비밀번호를 입력하세요.");
	String pw = scan.nextLine();
	if(dao.managerLogin(id, pw) > 0) {
		result = true;
	}else {
		System.out.println("올바른 값을 입력하세요");
		result = false;
	}
			return result;
}
		

		

//2021.06.25 각각의 예외 사항 : 회원가입시 발생할 수 있는 예외 처리 -> db 제약조건에 따라 자바에서도 처리 해줄 수 있게
//정보추가 : 생년월일, 운전경력 등 
	
	//회원 정보 삭제 메소드
	public  void deletMember() {
			System.out.println("회원의 정보를 삭제합니다.");
			memberList();
			System.out.println("삭제를 원하시는 멤버의 코드번호를 입력하세요.");
			int membercode = Integer.parseInt(scan.nextLine());
			
			int result = dao.deleteMember(membercode);
			
			if(result > 0) {
				System.out.println("멤버가 삭제되었습니다.");
			}else {
				System.out.println("해당 멤버의 정보가 없습니다.");
			}
	}
	//사용자의 현재 대여 정보 출력
		public void currInfo() {
			System.out.println("이용자의 렌트 현황을 출력합니다.");
			System.out.println("이용자의 id를 입력해주세요.");
			String id = scan.nextLine();
				
			if(id != null) {
				System.out.println(id+"의 대여 정보 입니다.");
				dao.currRentInfo(id);
			}else {
				System.out.println("id를 다시 입력하여주세요.");
				return;
			}
		}
}