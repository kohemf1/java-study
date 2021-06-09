package ch12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;

public class FootballPlayerFile {

	public static void main(String[] args) {

		//2.앞 Chapter에서 만들어본 축구선수 정보 파일로 저장하는 프로그램을 만들어 봅시다.
		//①축구선수 정보 인스턴스를 List<E>에 저장하는 프로그램을 만들어 봅시다.

		ArrayList<FootballPlayer> fbp = new ArrayList<FootballPlayer>();

		fbp.add(new FootballPlayer("손흥민", 7, "tot", 29 ));
		fbp.add(new FootballPlayer("케인", 10, "tot", 27 ));
		fbp.add(new FootballPlayer("메시", 10, "bar", 31 ));

		//②이 인스턴스 들을 파일로 저장하는 기능을 만들어 봅시다.
		
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("fbpList.ser"));
			out.writeObject(fbp);
			out.close();
			//③저장된 파일을 객체로 만드는 기능을 만들어봅시다.	
			ObjectInputStream in = 
					new ObjectInputStream(new FileInputStream("fbpList.ser"));
			ArrayList<FootballPlayer> fb1 = 
					(ArrayList<FootballPlayer>)in.readObject();
			
			for(FootballPlayer fb : fb1) {
				System.out.println(fb);		
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

}

}


class FootballPlayer implements Serializable{

	String name;
	int num;
	String team;
	int age;

	public FootballPlayer(String name, int num, String team, int age) {
		this.name = name;
		this.num = num;
		this.team = team;
		this.age = age;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", num=" + num + ", team=" + team + ", age=" + age + "]";
	}
	
}
