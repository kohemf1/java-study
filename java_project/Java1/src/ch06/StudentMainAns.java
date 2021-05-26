package ch06;

public class StudentMainAns {

	public static void main(String[] args) {
//		3.main()메소드에 아래 내용을 정의해봅시다.
//		①Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		StudentAns[] students = new StudentAns[10];
		
//		②Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		students[0] = new StudentAns("홍길동1", 100, 40, 85);
		students[1] = new StudentAns("홍길동2", 90, 50, 88);
		students[2] = new StudentAns("홍길동3", 80, 46, 63);
		students[3] = new StudentAns("홍길동4", 70, 47, 34);
		students[4] = new StudentAns("홍길동5", 60, 20, 54);
		students[5] = new StudentAns("홍길동6", 50, 80, 96);
		students[6] = new StudentAns("홍길동7", 40, 80, 70);
		students[7] = new StudentAns("홍길동8", 30, 60, 80);
		students[8] = new StudentAns("홍길동9", 20, 80, 40);
		students[9] = new StudentAns("홍길동10",10, 60, 100);
		
//		③배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		
		System.out.println("이름\t 국어 \t 영어\t 수학\t 총점\t평균");
		System.out.println("=======================================================");
		for(int i = 0; i < students.length; i++) {
			System.out.print(students[i].getName());
			System.out.print( "\t");
			System.out.print(students[i].getKor());
			System.out.print( "\t");
			System.out.print(students[i].getEng());
			System.out.print( "\t");
			System.out.print(students[i].getMath());
			System.out.print( "\t");
			System.out.print(students[i].getSum() + "\t");
			System.out.println(students[i].getAvg());
			System.out.println();
		}
		
	}

}
