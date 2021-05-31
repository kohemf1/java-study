package ex.infomanager2;


// 상속을 목적으로 하는 클래스
public abstract class Friend implements ShowData{

	// 이름 , 전화번호, 주소 
	 String name;
	 String phoneNumber;
	 String address;
	
	
	public Friend(String name, String phoneNumber, String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	
	


	public void showData() {
		System.out.println(" 이    름 :" + name);
		System.out.println("전화번호 :" + phoneNumber);
		System.out.println(" 주   소  :" + address);
	}
	
	//public void showBasicInfo() {}  // 상속해서 오버라이딩 할려고
	//public abstract void showBasicInfo();




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
