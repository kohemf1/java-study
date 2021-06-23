package car;


public class CarMain {

	public static void main(String[] args) {


		CarManager Cmanager = new CarManager(CarDao.getInstance());
		
		//Scanner sc = new Scanner(System.in);
		
		// 드라이버 로드
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cmanager.CarList();
	//	Cmanager.inputCarData();
	//	Cmanager.editCar();
//		Cmanager.delCar();
		
	}

}
