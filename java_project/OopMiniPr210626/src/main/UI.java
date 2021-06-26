package main;
//2021.06.25
//문제점 : 1.로그인 확인후 회원의 렌트 현황에서 새로운 메소드를 추가해야하지 하는지? -> 회원의 id or 이름을 입력 받아야하는 번거로움 
//2. 


import java.util.Scanner;

import manager.*;

public class UI {
	MemberManage mm = new MemberManage(ManagerDao.getInstance());
	CarManage cm = new CarManage(ManagerDao.getInstance());
//	CarManage2 cm2 = new CarManage2(ManagerDao2.getInstance());
	static boolean ck = false;
	
	// 멤버 로그인
	public void checkLogin() {
		ck = !ck;
	}
	// 멤버 로그아웃
	public void logout() {
		ck = false;
	}
	
	//전체 메뉴
	public void start() {
		System.out.println("프로그램을 시작합니다.");
		System.out.println("1.회 원 2.비회원 3.관리자 4.종료  선택하세요.");
		while(true) {
		int num = 0;
		
		num = Integer.parseInt(getUserInput());
			switch(num) {
			// 1번은 회원의 기능
			case 1 :
				menuMember();
				break;
			// 2번은 비회원 회원가입
			case 2 :
				menuNoneMM();
				break;
			// 3번은 관리자 기능	
			case 3 :
				menuManager();
				break;
			// 4번은 프로그램 강제 종료
			case 4 :
				System.out.println("프로그램을 종료 합니다.");
				System.exit(0);
				
	
			}
		}
	}
	//1번 회원 선택시
	// 멤버 로그인
	public void memberLogin() {

		System.out.println("회원의 아이디를 입력하세요.");
		String id = getUserInput();
		System.out.println("회원의 비밀번호를 입력하세요.");
		String pw = getUserInput();
		if(mm.login(id, pw) > 0) {
			checkLogin();
		}else {
			System.out.println("아이디 또는 비밀번호를 확인하세요");
			start();
		}	
	}
	// 관리자 로그인
	public void managerLogin() {
		System.out.println("관리자 로그인");
		System.out.println("관리자의 아이디를 입력하세요.");
		String id = getUserInput();
		System.out.println("관리자의 비밀번호를 입력하세요.");
		String pw = getUserInput();
		if(mm.login2(id, pw) > 0) {
			checkLogin();
		}else {
			System.out.println("아이디 또는 비밀번호를 확인하세요");
			start();
		}	
	}
	
	public void menuMember() {
	// 회원은 로그인을 먼저 진행해주세요.
		//1.대여 2.반납 3.대여 내역 4.회원정보수정 5. 로그아웃  
		// 2021 06 23
		//대여,반납 -> 25일 완료
		//2021 06 24
		//회원정보 수정, 결제기능 추가 x -> 
		int num = 0;
//		System.out.println("회원 로그인을 진행해주세요.");
		//로그인
		if(ck == false) {
			System.out.println("로그인을 합니다.");
			memberLogin();
		}else {
			System.out.println("이미 로그인 중입니다.");
		}
		
		while(true) {
			System.out.println("메뉴 선택을 해주세요.");
			System.out.println("1.대여 2.반납 3.대여이용현황 4.결제 정보 5.로그아웃");
			num = Integer.parseInt(getUserInput());
			switch(num) {	
			case 1 :
				//대여 메서드
				
//				System.out.println("대여합니다.");//
							
				cm.rentCar2();
				cm.rentCar();				
			
				break;
			case 2 : 
				//반납 메서드
				System.out.println("반납을 합니다."); // 반납도 대여처럼 순서바꿈
				cm.returnCar2();
				cm.returnCar();
				
				break;
			case 3 : 
				//차량 이용 현황 메서드
				System.out.println("차량 정보를 나타냅니다.");
				cm.carList();
				break;
			case 4 :
				//결제 정보
				break;
			case 5 :
				//로그인 상태일 경우
				if(ck == true) {
				System.out.println("로그아웃되었습니다.");
				logout();
				start();
				
				//로그인 상태가 아닌경우 

				}
			case 6 :
				cm.infoList();		
			}					
		}		
	}
	
	//2번 비회원 선택시
	public void menuNoneMM() {
		try {
		System.out.println("회원가입을 시작합니다.");
		mm.insertMember();
		} catch (ArrayIndexOutOfBoundsException e) {} // 회원가입 정보 잘못 입력시 예외처리 후 초기화면으로 돌아가게함
		finally {
			start();
		}
		System.out.println("회원가입이 완료되었습니다.");		
		start();
	}
	
	//3번 관리자 선택시
	//	1. 관리자 로그인 2. 회원 리스트 3.회원 정보 삭제 4.차량 등록 5.차량 삭제 6. 관리자 로그아웃
	public void menuManager() {
		System.out.println("관리자모드로 접속합니다.");
		System.out.println("로그인을 진행합니다.");
		
//	관리자 로그인
		if(ck == false) {
			System.out.println("로그인을 합니다.");
			managerLogin();			
		}else {
			System.out.println("이미 로그인 중입니다.");		
		}
		
		int num = 0;
		while(true) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1.회원 리스트 2.회원 정보 삭제 3.차량 등록 4.차량 삭제 5.관리자 로그아웃");
			num = Integer.parseInt(getUserInput());
			switch(num) {
			//회원 리스트
			case 1 :
				System.out.println("회원의 리스트를 출력합니다.");
				mm.memberList();	
				break;
			//회원 삭제
			case 2 :
				System.out.println("회원의 정보를 삭제합니다.");
				mm.deletMember();				
				break;
			// 차량 등록	
			case 3 :
				cm.inputCar();
				break;
			//차량 삭제
			case 4 :
				cm.deleteCar();
				break;
			//관리자 로그아웃
			case 5 :	
				//로그인 상태일 경우
				if(ck == true) {
				System.out.println("로그아웃되었습니다.");
				logout();
				start();
				//로그인 상태가 아닌경우 
				}
			}	
		}		
	}	
	public static String getUserInput() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		return input;
	}
}