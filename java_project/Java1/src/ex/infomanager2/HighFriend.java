package ex.infomanager2;

public class HighFriend extends Friend {

	//고교친구는 직장에서 어떤일을 하는지
	String work;
	
	public HighFriend(String name, String phoneNumber, String address, String work) {
		super(name, phoneNumber, address);
		this.work = work;
	}

	@Override 
	public void showData() {
		super.showData();
		System.out.println(" 직   업  :" + work);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNumber);
	}
	
	
}
