package practice060121;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FootballPlayer{


	private String name; 
	private int number; 
	private String team; 
	private int age;
	
	public FootballPlayer(String name, int number,
			String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {

		boolean chek = false;
		if( obj != null && obj instanceof FootballPlayer) {
			FootballPlayer a = (FootballPlayer)obj;
			if(this.team.equals(a.team) && this.name.equals(a.name)&&
					this.age == a.age) {
				chek = true;
			}
		}return chek;
		
	}

	@Override
	public int hashCode() {
		
		return age%10;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" +
	number + ", team=" + team + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		
//		List<FootballPlayer> fp = new ArrayList<>();
		Set<FootballPlayer> fp = new HashSet<>();
		
		
		
		fp.add(new FootballPlayer("Son", 7, "Tot", 29));
		fp.add(new FootballPlayer("Bale", 9, "Tot", 30));
		fp.add(new FootballPlayer("Kane", 10, "Tot", 28));
		fp.add(new FootballPlayer("Son", 11, "Tot", 29));
		
		
		
		Iterator<FootballPlayer> itr = fp.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}


}
