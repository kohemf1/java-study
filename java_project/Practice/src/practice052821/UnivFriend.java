package practice052821;

public class UnivFriend extends Friend {
	
	String major;
	
	
	public UnivFriend(String name, String phoneNum, String address, String major) {
		super(name, phoneNum, address);
		this.major = major;
	}


	@Override
	public void friendData() {
		super.friendData();
		System.out.println(" 전공 : " + major);
	}


	@Override
	public void simpleData() {
		
		System.out.println(" 이름 : " + name);
		System.out.println(" 번호 : " + phoneNum);
		System.out.println(" 전공 : " + major);
		
	}
	
	

}
