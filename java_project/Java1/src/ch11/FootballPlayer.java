package ch11;


class FootballPlayer implements Comparable<FootballPlayer>  { 

	String name; 
	int number;
	String team; 
	int age; 


	public FootballPlayer( String name, int number, String team, int age) {
		super();
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public void showData() {	
		System.out.println(name + " / " + number + "번 / " + team + " / " + age + "살 / ");
	}

//	@Override
//	public int hashCode() {
//		return age % 3;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		
//		boolean result = false;
//		
//		if(obj != null & obj instanceof FootballPlayer) {
//			FootballPlayer fAge = (FootballPlayer) obj;
//			if(this.team.equals(fAge.team) && this.name.equals(fAge.name) && 
//					this.team == fAge.team) {
//				result = true;
//			}
//		} return result;
//	}
//	
//	public String toString() {
//		return String.valueOf(age);
//	}

	
	public void showInfo() {
		System.out.printf("%s, %d, %s, %d \n", this.name, this.number, 
				this.team, this.age);
	}
	
	@Override
	public int compareTo(FootballPlayer o) {
		if(team.hashCode() < o.team.hashCode()) {
			return -1;
			}else if (team.hashCode() > o.team.hashCode()) { 
				return 1;
			} else {
				if(name.hashCode() < o.name.hashCode()) {
					return -1;				
			}else if(name.hashCode() > o.name.hashCode()) {
				return 1;
			} else return this.number - o.number;
//			{
//				if( number < o.number) {
//					return -1;
//				} else if( number == o.number) {
//					return 0;
//				} else(number > o.number){
//					return -1;
//				}
//			}
	}
}

}

