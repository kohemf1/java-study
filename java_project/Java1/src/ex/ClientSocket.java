package ex;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

	public static void main(String[] args) {
	
		// SocketServer의 IP와 Port 번호로 연결 신청 -> Socket 객체 생성
		try {
			Socket socket = new Socket("localhost",9999);
		
			if(socket != null) {
				System.out.println("서버 접속 완료");
			}
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			dout.writeUTF("Hi !! Client Message");
			dout.flush();
			dout.close();
			socket.close();
			
			
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

}
