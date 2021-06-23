package cartest3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarDao {

	private CarDao() {	
	}
	//클래스 내부 인스턴스
	static private CarDao Cdao= new CarDao();
	// 반환 처리
	public static CarDao getInstance() {
		return Cdao;
	}

	//데이터 검색

	//매개변수Connection 객체 Statement를 만들기위해
	ArrayList<Car> getCarList(Connection conn){

		ArrayList<Car> Clist = null;

		//DB select결과를 Clist에저장
		Statement Cstmt = null;
		ResultSet Crs = null;


		try {
			Cstmt = conn.createStatement();

			String sql = "select * from Car order by idx";

			// 결과받기
			Crs = Cstmt.executeQuery(sql);

			Clist = new ArrayList<>();
			//데이터를 Car 객체로 생성 (list)
			while(Crs.next()) {
				Clist.add(new Car(Crs.getInt(1),
						Crs.getString(2),
						Crs.getString(3),
						Crs.getString(4),
						Crs.getInt(5),
						Crs.getInt(6),
						Crs.getString(7),
						Crs.getString(8)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if(Crs != null) {
				try {
					Cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		return Clist;

	}

	// 데이터 저장
	// 사용자에게 받은데이터 -> Car 객체

	int insertCar(Connection conn, Car car) {

		int result = 0;
		// 전달받은 데이터를 테이블에 저장(결과 값 반환)

		PreparedStatement Cpstmt = null;

		try {
			String sql = 
					"insert into Car values (car_idx_SEQ.nextval,?,?,?,?,?,?,?)";

			Cpstmt = conn.prepareStatement(sql);
			Cpstmt.setString(1, car.getCarnumber());
			Cpstmt.setString(2, car.getCarname());
			Cpstmt.setString(3, car.getCarsize());
			Cpstmt.setInt(4, car.getCarseat());
			Cpstmt.setInt(5, car.getCaryear());
			Cpstmt.setString(6, car.getFuel());
			Cpstmt.setString(7, car.getRent());

			result = Cpstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(Cpstmt != null) {
				try {
					Cpstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		return result;
	}


	// 데이터 수정

	int editCar(Connection conn, Car car) {

		int result = 0;

		//전달받은 Car객체의 데이터로 테이블에 저장 -> 결과값 반환
		PreparedStatement Cpstmt = null;
		try {
			String sql = 
					"update car set carnumber=?,carname=?,carsize=?,carseat=?,caryear=?,fuel=?,rent=? ";		

			Cpstmt = conn.prepareStatement(sql);
			Cpstmt.setString(1, car.getCarnumber());
			Cpstmt.setString(2, car.getCarname());
			Cpstmt.setString(3, car.getCarsize());
			Cpstmt.setInt(4, car.getCarseat());
			Cpstmt.setInt(5, car.getCaryear());
			Cpstmt.setString(6, car.getFuel());
			Cpstmt.setString(7, car.getRent());
			result = Cpstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(Cpstmt != null) {
				try {
					Cpstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	int rentCar(Connection conn, String rent, String carnumber) {

		int result = 0;

		//전달받은 Car객체의 데이터로 테이블에 저장 -> 결과값 반환
		PreparedStatement Cpstmt = null;
		try {
			String sql = 
					"update car set rent=? where carnumber=? ";		

			Cpstmt = conn.prepareStatement(sql);
			Cpstmt.setString(1, rent);
			Cpstmt.setString(2, carnumber);
			
			result = Cpstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(Cpstmt != null) {
				try {
					Cpstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	int returnCar(Connection conn, String rent, String carnumber) {

		int result = 0;

		//전달받은 Car객체의 데이터로 테이블에 저장 -> 결과값 반환
		PreparedStatement Cpstmt = null;
		try {
			String sql = 
					"update car set rent=? where carnumber=? ";		

			Cpstmt = conn.prepareStatement(sql);
			Cpstmt.setString(1, rent);
			Cpstmt.setString(2, carnumber);
			
			result = Cpstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(Cpstmt != null) {
				try {
					Cpstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// 테이블 데이터 삭제
	// 사용자한테 코드번호 받아서 처리
	int deleteCar(Connection conn, int idx) {

		int result = 0;

		// 데이터베이스 처리
		PreparedStatement Cpstmt = null;


		String sql = "delete from Car where idx=?";

		try {
			Cpstmt = conn.prepareStatement(sql);
			Cpstmt.setInt(1, idx);

			result = Cpstmt.executeUpdate();




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(Cpstmt != null) {
				try {
					Cpstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		return result;
	}
}


