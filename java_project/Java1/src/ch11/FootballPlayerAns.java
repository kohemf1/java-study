package ch11;

import java.util.*;

public class FootballPlayerAns implements Comparable<FootballPlayerAns> {
	
	private String name1;
	private int number1;
	private String team1;
	private int age1;
	
	public FootballPlayerAns(String name1, int number1, String team1, int age1) {
		this.name1 = name1;
		this.number1 = number1;
		this.team1 = team1;
		this.age1 = age1;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public int getAge1() {
		return age1;
	}

	public void setAge1(int age1) {
		this.age1 = age1;
	}

	@Override
	public String toString() {
		return "FootballPlayerAns [name1=" + name1 + ", number1=" + number1 +
				", team1=" + team1 + ", age1=" + age1 + "]";
	}
	
	
	
	@Override //문제2
	public boolean equals(Object obj) {
		
		boolean chk = false;
		
		if(obj != null && obj instanceof FootballPlayerAns) {
			FootballPlayerAns player = (FootballPlayerAns) obj;
			if(this.team1.equals(player.team1) && this.name1.equals(player.name1)
					&& this.age1 == player.age1) {
				chk = true;
			}
		}		
		return chk;
	}

	@Override //문제2
	public int hashCode() {
		return age1&10;
	}

	//3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고,
			//같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
	@Override
	public int compareTo(FootballPlayerAns o) {
		int result = this.team1.compareTo(o.getTeam1())*-1; // 음수 양수 0 나올수있다
		if(result == 0) {
			result = this.name1.compareTo(o.getName1());
			if(result == 0) {
				result = this.number1 - o.getNumber1();
			}
		}
		return result;
	}
			
			
	public static void main(String[] args) {
		//1.축구선수 인스턴스를 저장할 수 있는 List<E> 
		//컬렉션 인스턴스를 생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		
		//List<FootballPlayerAns> players = new ArrayList<>();
		
		// 2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도
		// Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		
		//Set<FootballPlayerAns> players = new HashSet<FootballPlayerAns>();
		
		
		//3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고,
		//같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
		TreeSet<FootballPlayerAns> players = new TreeSet<>();
		
		
		
		// 데이터 저장
		players.add(new FootballPlayerAns("Son1", 7, "Tot", 27));
		players.add(new FootballPlayerAns("Park1", 7 ,"Man", 37));
		players.add(new FootballPlayerAns("Son1", 9 ,"Tot", 27));
		players.add(new FootballPlayerAns("Son2", 20 ,"Tot", 17));
		players.add(new FootballPlayerAns("Park2", 20 ,"Man", 31));
		players.add(new FootballPlayerAns("Park2", 21 ,"Man", 31));
		
		
		System.out.println(" 요소의 개수 : " + players.size());
		
		
		Iterator<FootballPlayerAns> itr = players.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//4.축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는
		//Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.
		
		HashMap<Integer, FootballPlayerAns> players2 = new HashMap<>();
		
		players2.put(7,new FootballPlayerAns("Son1", 7, "Tot", 27));
		players2.put(10,new FootballPlayerAns("Kane", 10, "Tot", 26));
		players2.put(20,new FootballPlayerAns("Kane2", 20, "Tot", 16));
		
		System.out.println("------------------------------");
		
		Set<Integer> set = players2.keySet(); //set으로 키값을 만든거.
		Iterator<Integer> itr2 = set.iterator();
		while(itr2.hasNext()) {
			System.out.println(players2.get(itr2.next()));
		}
		
		
	}

}
