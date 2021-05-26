package ch07;

public class PersonManger {

	public static void main(String[] args) {
		
//		Male m = new Male("손흥민", "920101-1111111", 30, "축구", "스포츠");
//		m.hello();
//		m.studying();
		
		Male m = new Male("손흥민", 9207071777777L, "축구", "스포츠");
		m.hello();
		m.studying();
		
//		Female f = new Female("유리", "777777-7777777", 27, "경영", "검정색");
//		f.hello();
//		f.studying();
		
		Female f = new Female("유리", 0111114111111L, "경영", "검정색");
		f.hello();
		f.studying();
			
		Person p = new Person("홍철", 9812121111111L);
		
		p.hello();
		
	}
 	
}
