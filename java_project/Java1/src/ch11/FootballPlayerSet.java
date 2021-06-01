package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FootballPlayerSet {

	public static void main(String[] args) {
		
		Set<FootballPlayer> fpSet = new HashSet<FootballPlayer>();
		
	//2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록 Set<E> 
	//컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		
		fpSet.add(new FootballPlayer("손흥민", 7, "토트넘", 29));
		fpSet.add(new FootballPlayer("안정환", 10, "수원", 30));
		fpSet.add(new FootballPlayer("이천수", 8, "인천", 31));
		fpSet.add(new FootballPlayer("안정환", 10, "수원", 30));
		
		
		Iterator<FootballPlayer> itr = fpSet.iterator();
		
		while(itr.hasNext()) {
			itr.next().showData();
		}
	}

}
