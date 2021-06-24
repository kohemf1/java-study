package cartest4;


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
		
//		Cmanager.CarList(); // 카 리스트 출력			
//		Cmanager.rentCar(); // 자동차 대여
//		Cmanager.returnCar(); // 자동차 반납
//		Cmanager.inputCarData(); // 자동차 추가
		Cmanager.editCar(); // 자동차 정보 수정
//		Cmanager.delCar(); // 자동차 삭제
//		Cmanager.rentList(); // 대여중인 차량
//		Cmanager.availableList(); // 대여 가능 차량
	}

}
