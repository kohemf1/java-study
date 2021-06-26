package main;
public class Main_test {
	public static void main(String[] args) {	
		UI ui = new UI();							
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ui.start();						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}	
}