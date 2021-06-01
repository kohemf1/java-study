package ch11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ex.infomanager3.Friend;

public class FootballPlayerList  {

	public static void main(String[] args) {
		//1.축구선수 인스턴스를 저장할 수 있는 List<E> 
		//  컬렉션 인스턴스를 생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다

		ArrayList<FootballPlayer> fpList = new ArrayList<>();
		
		fpList.add(new FootballPlayer("손흥민", 7, "토트넘", 29));
		fpList.add(new FootballPlayer("안정환", 10, "수원", 33));
		fpList.add(new FootballPlayer("이천수", 8, "인천", 31));

		Iterator<FootballPlayer> itr = fpList.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
			}
	}

}
