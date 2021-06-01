package ch11;

import java.util.*;

public class FootballPlayerTreeSet {
	//3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고,
	//같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
	public static void main(String[] args) {
		
		TreeSet <FootballPlayer> fpTSet = new TreeSet<FootballPlayer>();
		
		fpTSet.add(new FootballPlayer("손흥민", 7, "토트넘", 29));
		fpTSet.add(new FootballPlayer("이천수", 8, "인천", 31));
		fpTSet.add(new FootballPlayer("안정환", 10, "수원", 30));
		fpTSet.add(new FootballPlayer("김흥국", 3, "수원", 30));
		fpTSet.add(new FootballPlayer("안정환", 11, "수원", 30));
		
		Iterator<FootballPlayer> itr = fpTSet.iterator();
		while(itr.hasNext()) {
			//System.out.println(itr.next());
			itr.next().showInfo();
		}
		
	}

}
