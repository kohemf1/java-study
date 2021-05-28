package practice052821;

public class HighFriend extends Friend {
	
	String job;
	
	public HighFriend(String name, String phoneNum, String address, String job) {
		super(name, phoneNum, address);
		this.job = job;
		
	}
	@Override
	public void friendData() {
		super.friendData();
		System.out.println(" 직업 : " + job);
	}
	@Override
	public void simpleData () {
		System.out.println(" 이름 : " + name);
		System.out.println(" 번호 : " + phoneNum);
	}

}
