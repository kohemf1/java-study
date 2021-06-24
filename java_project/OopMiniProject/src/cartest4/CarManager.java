package cartest4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CarManager {
	
	private CarDao Cdao;
	private Scanner sc;
	
	public CarManager(CarDao Cdao) {
		this.Cdao = Cdao;
		sc = new Scanner(System.in);
				
	}
	
	//DAO에서 데이터 리스트받고 출력
	// 자동차 리스트 출력
	void CarList() {
		// connection 생성 -> 트렌젝션 처리
		Connection conn = null;
		String OOP1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
			
		try {
			conn = DriverManager.getConnection(OOP1, user, pw);
			
			List<Car> Clist = Cdao.getCarList(conn);
			
			System.out.println("자동차 정보 리스트");
			System.out.println("------------------");
			System.out.println("코드번호\t차번호\t차이름 \t차크기\t탑승인원 \t연식\t연료\t대여현황");
			System.out.println("(대여현황 0 이면 렌트가능 1이면 렌트 불가)");
			System.out.println("--------------------------------------------------");
			
			for(Car car : Clist) {
				System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\t%s\t%s\n",
				car.getCarcode(),
				car.getCarnumber(),
				car.getCarname(),
				car.getCarsize(),
				car.getCarseat(),
				car.getCaryear(),
				car.getFuel(),
				car.getRent());
			}			
			System.out.println("------------------------------------------");							
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
	
//	Scanner 입력 -< insertCar 메소드로 저장
	// 자동차 추가
	void inputCarData() {
		
		Connection conn = null;
		String OOP1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(OOP1, user, pw);
			
			System.out.println("차량 정보를 입력해주세요");
			System.out.println("차번호 차이름 차크기 탑승인원 연식 연료");
			System.out.println("순서로 입력해주세요");
			String inputCarData = sc.nextLine();
			String[] cardata = inputCarData.split(" ");
			
			Car car = new Car(0, cardata[0], cardata[1],cardata[2],
					Integer.parseInt(cardata[3]), 
					Integer.parseInt(cardata[4]), cardata[5],cardata[6]);
			
			int result = Cdao.insertCar(conn, car);
					
			if ( result > 0) {
				System.out.println("입력 완료");
			} else {
				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 자동차 데이터 수정
	void editCar() {
		Connection conn = null;
		
		String OOP1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(OOP1,user,pw);
			
			CarList();
			
			System.out.println("자동차 코드를 입력해주세요");
			int carcode  = sc.nextInt();
			System.out.println("정보를 수정합니다.");
			System.out.println("차번호 차이름 차크기 탑승인원 연식 연료");
			System.out.println("순서로 입력해주세요");
			String editCarData = sc.nextLine();
			String[] ecardata = editCarData.split(" ");
			
			Car car = new Car(Integer.parseInt(ecardata[0]), ecardata[1], ecardata[2],ecardata[3],
					Integer.parseInt(ecardata[4]), 
					Integer.parseInt(ecardata[5]), ecardata[6],ecardata[7]);
			
			int result = Cdao.editCar(conn, car);
			
			if(result > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 자동차 대여
	void rentCar() {
		Connection conn = null;
		
		String OOP1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(OOP1,user,pw);
			availableList();
			System.out.println("대여할거면  1 을 입력");
			String rent = sc.nextLine();
			System.out.println("대여할 차량번호 입력");
			String carnumber = sc.nextLine();
		
			int result = Cdao.rentCar(conn, rent, carnumber);
			
			if(result > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 자동차 반납
	void returnCar() {
		Connection conn = null;
		
		String OOP1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(OOP1,user,pw);
			
			
			rentList();
			
			System.out.println("반납할 차량번호 입력");
			String carnumber = sc.nextLine();
			System.out.println("반납할거면 0 을 입력");
			String rent = sc.nextLine();
//			System.out.println("반납할 차량번호 입력");
//			String carnumber = sc.nextLine();
			
			int result = Cdao.returnCar(conn, rent, carnumber);
		
			if(result > 0) {
				System.out.println("반납 완료");
			} else  {
				System.out.println("반납 실패");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 렌트 중인 차량 목록
	void rentList() {
		Connection conn = null;
		String OOP1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		
		try {
			conn = DriverManager.getConnection(OOP1, user, pw);
			
			List<Car> Clist = Cdao.rentList(conn);
			
			System.out.println("렌트 중인 차량 목록");
			System.out.println("------------------");
			System.out.println("코드번호\t차번호\t차이름 \t차크기\t탑승인원 \t연식\t연료");
			System.out.println("--------------------------------------------------");
			
			for(Car car : Clist) {
				System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\t%s\n",
				car.getCarcode(),
				car.getCarnumber(),
				car.getCarname(),
				car.getCarsize(),
				car.getCarseat(),
				car.getCaryear(),
				car.getFuel());
			}
			
			System.out.println("------------------------------------------");
							
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// 이용 가능 차량 목록
	
	void availableList() {
		Connection conn = null;
		String OOP1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		
		try {
			conn = DriverManager.getConnection(OOP1, user, pw);
			
			List<Car> Clist = Cdao.availableList(conn);
			
			System.out.println("대여 가능 차량 목록");
			System.out.println("------------------");
			System.out.println("코드번호\t차번호\t차이름 \t차크기\t탑승인원 \t연식\t연료");
			System.out.println("--------------------------------------------------");
			
			for(Car car : Clist) {
				System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\t%s\n",
				car.getCarcode(),
				car.getCarnumber(),
				car.getCarname(),
				car.getCarsize(),
				car.getCarseat(),
				car.getCaryear(),
				car.getFuel());
			}
			
			System.out.println("------------------------------------------");
							
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 자동차 삭제
	
	void delCar() {
		Connection conn = null;
		String OOP1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(OOP1,user,pw);
		
		CarList();
		System.out.println("삭제를 원하시는 코드번호를 입력해주세요");
		int carcode = Integer.parseInt(sc.nextLine());
		
		int result = Cdao.deleteCar(conn, carcode);
		
		if(result > 0) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제할 차량이 없습니다.");
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	}
	

	
}
