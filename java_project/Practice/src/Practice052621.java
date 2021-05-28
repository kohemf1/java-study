
public class Practice052621 {

	//4-1 문장들을 조건식으로 바꿔라
	//1)int형 변수 x가 10보다  크고 20보다 작을때 true인 조건식
	// 10 < x && x < 20
	//2)char형 변수 ch가 공백이나 탭이 아닐때 treu인 조건식
	//  ch = '' || ch = '\t'
	//3)char형 변수 ch가 'x' 또는 'X'일때 true인 조건식
	// ch = 'x' || ch = 'X'
	//4)char형 변수 ch가 수잦 ('0' ~ '9')일 대 true
	// ch >= '0' && ch <= '9'
	//char형 변수 ch가 영문자일때 true
	// ( ch >= 'a' && ch <= 'z') || ( ch >= "A" && ch <= 'Z')
	
	public static void main(String[] args) {
		
		// 1~ 20 중에 2 또는 3의 배수가 아닌 수의 총합
		int sum = 0;
		for(int i = 1; i <=20; i++) {
			if( i%2!=0 && i%3!=0)
				sum += i;
		}
		System.out.println(sum);		
		
		//1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10) 계산
		int sum1 = 0;
		int sumAll = 0;
		
		for(int i = 1; i <= 10; i++) {
			sum1 += i;
			sumAll += sum1;
		}System.out.println(sumAll);
		
		
		// 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이
		//100이상이 되는지 구하시오.
		
		int sum3 = 0;
		for(int i = 1; true; i++) {
			if( i%2==1 ) {
				sum3 += i;
			} else if ( i%2 == 0) {
				sum3 -= i;
			} else if ( sum3 >= 100) {
				break;
			}
		} 
		
		
		
		
	}
}
