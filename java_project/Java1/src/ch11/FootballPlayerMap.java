package ch11;

import java.util.*;

public class FootballPlayerMap {
	//4.축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 Map<K,V> 
	// 인스턴스를 이용해서 프로그램을 만들어봅시다.
	public static void main(String[] args) {
		
		HashMap<Integer, FootballPlayer> fpMap = new HashMap<>();
		
		fpMap.put(7,new FootballPlayer("손흥민", 7, "토트넘", 29));
		fpMap.put(10,new FootballPlayer("안정환", 10, "수원", 30));
		fpMap.put(8,new FootballPlayer("이천수", 8, "인천", 31));
		fpMap.put(11,new FootballPlayer("김흥국", 11, "수원", 30));
		
		
		
		
	}

}
