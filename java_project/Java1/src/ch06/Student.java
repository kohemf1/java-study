package ch06;

public class Student {

	private String name;
	private int korGrade;
	private int engGrade;
	private int matGrade;

	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return this.name;
	}

	void setKorGrade (int korGrade) {
		this.korGrade = korGrade;
	}
	int getKorGrade() {
		return this.korGrade;
	}
	void setEngGrade (int engGrade) {
		this.engGrade = engGrade;
	}
	int getEngGrade() {
		return this.engGrade;
	}
	void setMatGrade (int matGrade) {
		this.matGrade = matGrade;
	}
	int getMatGrade() {
		return this.matGrade;
	}
	
	public Student(String name, int korGrade, int engGrade, int matGrade) {
		this.engGrade = engGrade;
		this.korGrade = korGrade;
		this.matGrade = matGrade;
		this.name = name;
	}
	int total() {
		return korGrade + engGrade + matGrade;
	}
	
	float avg() {
//		return (float) Math.ceil((korGrade + engGrade + matGrade)/3);
		return (korGrade + engGrade + matGrade)/3f;
	}
	
	void info() {
		System.out.println(name + "의성적");
		System.out.println("국어 :" + korGrade + " 영어 :" + engGrade + " 수학 :" + matGrade);
		System.out.println("평균 : " + total());
//		System.out.println("평균 : " + Math.ceil(total()));
		System.out.println("총점 : " + avg());
	}

	public static void main(String[] args) {

//		int[] kor = new int[10];
//		int[] eng = new int[10];
//		int[] mat = new int[10];
		
		int[] kor = {83,75,95,83,95,78,89,95,98,98};
		int[] eng = {85,83,82,81,82,83,84,85,86,87};
		int[] mat = {65,78,98,65,98,63,96,99,97,100};
		
//		kor[0] = 85;	kor[1] = 80;	kor[2] = 85;	kor[3] = 85;	kor[4] = 85;	
//		kor[5] = 85;	kor[6] = 85;	kor[7] = 85;	kor[8] = 85;	kor[9] = 85;	

//		eng[0] = 85;	eng[1] = 90;	eng[2] = 85;	eng[3] = 75;	eng[4] = 85;	
//		eng[5] = 85;	eng[6] = 65;	eng[7] = 85;	eng[8] = 85;	eng[9] = 80;	

//		mat[0] = 75;	mat[1] = 75;	mat[2] = 55;	mat[3] = 75;	mat[4] = 75;	
//		mat[5] = 75;	mat[6] = 85;	mat[7] = 95;	mat[8] = 75;	mat[9] = 75;	

		for( int i = 0; i < 10; i++ ) {
			System.out.println("국어 : " + kor[i] + " 영어 : "+ eng[i] +" 수학 : " + mat[i]);
		}

		int sum1 = 0;
		for( int j = 0; j < kor.length ; j++ ) {
			sum1 += kor[j];
		}
		int sum2 = 0;
		for( int k = 0; k < eng.length ; k++ ) {
			sum2 += eng[k];
		}
		int sum3 = 0;
		for( int z = 0; z < mat.length ; z++ ) {
			sum3 += mat[z];
		}
		System.out.println("국어 합계  :" + sum1 + " 영어 합계  :" + sum2 + " 수학 합계  :" + sum3);
		System.out.println("국어 평균  :" + sum1/10 + " 영어 평균  :" + sum2/10 + " 수학 평균  :" + sum3/10);
///////////////////////////////////////////////////////////////////////////////////////////////////

		Student[] s = new Student[2];
		s[0] = new Student("승기",80,80,80);
		s[1] = new Student("상류",90,85,75);
		s[0].info();
		s[1].info();
	
	}
}
