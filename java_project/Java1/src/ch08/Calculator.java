package ch08;

public interface Calculator {
	
	long add(long n1, long n2);
	long substract(long n1, long n2 );
	long multiply(long n1, long n2 );
	double divide(double n1, double n2 );
	
}
//1.Calulator 인터페이스를 상속하는 추상 클래스를 정의해봅시다.
//2.Calulator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다.
//3.다형성의 특징으로 상위 타입인 인터페이스 타입의 참조변수에 인터페이스를 구현한 클래스 타입의 인스턴스를 참조하는 코드를 작성해 봅시다.