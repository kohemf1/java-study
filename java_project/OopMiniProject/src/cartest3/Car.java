package cartest3;

public class Car {
	
	int idx;

	private String carnumber;
	private String carname;
	private String carsize;
	private int carseat;
	private int caryear;
	private String fuel;
	private String rent;
	
	
	public Car(int idx, String carnumber, String carname,
			String carsize, int carseat, int caryear, String fuel, String rent) {
		super();
		this.idx = idx;
		this.carnumber = carnumber;
		this.carname = carname;
		this.carsize = carsize;
		this.carseat = carseat;
		this.caryear = caryear;
		this.fuel = fuel;
		this.rent = rent;
	}



	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getCarnumber() {
		return carnumber;
	}



	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}



	public String getCarname() {
		return carname;
	}



	public void setCarname(String carname) {
		this.carname = carname;
	}



	public String getCarsize() {
		return carsize;
	}



	public void setCarsize(String carsize) {
		this.carsize = carsize;
	}



	public int getCarseat() {
		return carseat;
	}



	public void setCarseat(int carseat) {
		this.carseat = carseat;
	}



	public int getCaryear() {
		return caryear;
	}



	public void setCaryear(int caryear) {
		this.caryear = caryear;
	}



	public String getFuel() {
		return fuel;
	}



	public void setFuel(String fuel) {
		this.fuel = fuel;
	}



	public String getRent() {
		return rent;
	}



	public void setRent(String rent) {
		this.rent = rent;
	}



	@Override
	public String toString() {
		return "Car [idx=" + idx + ", carnumber=" + carnumber + 
				", carname=" + carname + ", carsize=" + carsize
				+ ", carseat=" + carseat + ", caryear=" + caryear +
				", fuel=" + fuel + "]";
	}
	
	
}
