package practice052821;

import java.util.Scanner;

public class FriendInfoHandler {
	
	// 입력 
	
	Friend[] friends;
	int numOfFriend;
	
	public FriendInfoHandler(int num) {
		this.friends = new Friend[num];
		this.numOfFriend = 0;
	}
	
	public void addFriend(int choice) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" 이름을 입력 하세요 >> " );
		String name = sc.nextLine();
		System.out.println(" 전화번호를 입력해주세요 >> ");
		String phoneNum = sc.nextLine();
		System.out.println(" 주소를 입력해주세요 >> ");
		String address = sc.nextLine();
		
		if( choice == 1) {
			System.out.println(" 직업을 입력하세요 >> ");
			String job = sc.nextLine();
			HighFriend hFriend = new HighFriend(name, phoneNum, address, job);
			friends[numOfFriend] = hFriend;
			numOfFriend++;
		}else if (choice == 2 ) {
			System.out.println(" 전공을 입력하세요 >> ");
			String major = sc.nextLine();
			UnivFriend uFriend = new UnivFriend(name, phoneNum, address, major);
			friends[numOfFriend] = uFriend;
			numOfFriend++;
		}
	}
	
	public void addFriends(Friend f) {
		friends[numOfFriend++] = f;
		System.out.println(" 저장 됬습니다. ");
	}
	
	public void FrinedData() {
		if(numOfFriend > 0) {
			for(int i = 0; i < numOfFriend; i++) {
				friends[i].friendData();
			}
		}else {
			System.out.println(" 정보가 없습니다.");
		}
	}
	
	public void SimpleData() {
		if(numOfFriend > 0) {
			for(int i = 0; i < numOfFriend; i++) {
				friends[i].simpleData();
			}
		}else {
			System.out.println(" 정보가 없습니다. ");
		}
	}
	
	
}
