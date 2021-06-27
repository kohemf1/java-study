package rent;

public class Rent {
	private int rentcode;
	private int pay;
	private int rentperiod;
	private String rent_date;
	private int carcode;
	private int membercode;
	private int managercode;
	
	public Rent() {
		
	}
	public int getRentcode() {
		return rentcode;
	}
	public void setRentcode(int rentcode) {
		this.rentcode = rentcode;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getRentperiod() {
		return rentperiod;
	}
	public void setRentperiod(int rentperiod) {
		this.rentperiod = rentperiod;
	}
	public String getRent_date() {
		return rent_date;
	}
	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}
	public int getCarcode() {
		return carcode;
	}
	public void setCarcode(int carcode) {
		this.carcode = carcode;
	}
	public int getMembercode() {
		return membercode;
	}
	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}
	public int getManagercode() {
		return managercode;
	}
	public void setManagercode(int managercode) {
		this.managercode = managercode;
	}
}
