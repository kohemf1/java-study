
public class Practice052421 {

	public static void main(String[] args) {
		// 연습문제 3-2 바구니갯수 구하기
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket = numOfApples / sizeOfBucket + (numOfApples%sizeOfBucket > 0 ? 1 : 0);
		
		System.out.println("필요한 바구니수 : " + numOfBucket);
		
		//연습문제 3-3 양수 음수 0 구하기
		
		int num = 0;
		System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : "0"));
		//연습문제 3-4 백이하자리 버리기
		int num1 = 456;
		System.out.println(num1/100*100);
		//3-5 일의자리를 1로 바꿔라
		int num2 = 915;
		System.out.println(num2/10*10+1);
		//3-6 변수보다 크면서 가까운 10의 배수에서 변수를 뺸 값을 구해라  ex)변수가 24면 30-24 해서 값이 6
		int num3 = 57;
		System.out.println(((num3/10+1)*10)-num3);
		System.out.println(10-num3%10); //다른정답
		//3-9 ch가 영문자이거나 숫자일때 true가 나오게해라
		char ch = '8';
		boolean b = ('a' <= ch && ch <='z' ) || ('A' <= ch && ch <= 'Z') ||
				('0' <= ch && ch <= '9');
		System.out.println(b);
		
		//3-10 대문자를 소문자로 바꿔라 소문자가 대문자보다 문자코드 32더큼
		char ch1 = 'A';
		char lowerCase = ()
		
	}

}
