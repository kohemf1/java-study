package ex;

public class RunnableThread {

	public static void main(String[] args) {
		
		// Runnable 타입의 인스턴스 생성
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		// Thread 인스턴스 생성
		// new Thread (Runnable target)
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		// Thread start()
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {	
			e.printStackTrace();
		}
									// 문자열 끼리 덧셈이라서 괄호 해줘야함
		System.out.println("1 ~ 100 합 : " + (at1.getNum() + at2.getNum()));
	}
}

class AdderThread extends Sum implements Runnable{

	int startNum;
	int endNum;
	
	public AdderThread(int n1, int n2) {
		this.startNum = n1;
		this.endNum = n2;
	}
	
	@Override
	public void run() { // Runnable이 가지고있는 메소드 오버라이딩.		
		
		for(int i = startNum; i <= endNum; i++) {
			addNum(i);
		}
	}
}

class Sum {
	int num;
	
	public void addNum(int n) {
		num += n;
	}
	
	public int getNum() {
		return num;
	}
}

