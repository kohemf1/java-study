package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest2 {
	public static void main(String[] args) {

		// HashSet 저장 공간 생성 
		// 인스턴스 저장, 중복저장을 허용하지 않는다. 저장순서를 저장하지 않는다.

		//HashSet<String> hashSet = new HashSet<String>();
		//HashSet<Integer> hashSet = new HashSet<Integer>();

		Set<SimpleNumber> hashSet = new HashSet<>();

		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(20));

		// 데이터의 일괄 처리
		//Iterator<String> itr = hashSet.iterator();
		Iterator<SimpleNumber> itr = hashSet.iterator();

		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}

class SimpleNumber{

	int num;

	SimpleNumber(int num){
		this.num = num;
	}

	@Override
	public int hashCode() {
		return num % 3; 
	}

	@Override
	public boolean equals(Object obj) {

		boolean result = false;

		// obj 는 null이 아니고, obj는 SimpleNumber타입으로 형변환이 가능해야한다.
		//(비교하기 위해서.)
		if(obj != null && obj instanceof SimpleNumber) {
			SimpleNumber sNum = (SimpleNumber) obj;
			if(this.num == sNum.num) {
				result = true;
			}
		}		
		return result;
	}

	public String toString() {
		return String.valueOf(num);
	}


















}