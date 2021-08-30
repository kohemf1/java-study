package com.aia.socket.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.aia.socket.domain.Message;
import com.google.gson.Gson;

public class EchoHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
	
	// WebSocketSession : 클라이언트의 Socket 정보를 가지는 객체
	// 소켓 서버에 접속한 모든 사용자에게 메시지를 전송할때 사용할수있다.
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	// 특정 사용자에게 메시지를 전송할 수 있다.
	private Map<String, WebSocketSession> sessionMap = new HashMap<String, WebSocketSession>();

	
	// Client에서 접속을 요청하면 메소드가 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		// 사용자 정보 받고, Client의 WebSocketSession 저장
		// 사용자(id,WebSocketSession)
		// WebSocketSession + HttpSession(로그인한 정보) 설정
		
		String chatMember = (String) session.getAttributes().get("user");
		//String chatMember = ((LoginInfo) session.getAttributes().get("loginInfo")).getMembeId();

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + chatMember);

		sessionList.add(session);
		// 채팅 참여자의 아이디를 식별키로 Map에 저장
		sessionMap.put(chatMember, session);

		logger.info("{} 연결되었습니다.", session.getId()+":"+chatMember);

		System.out.println("채팅 참여자 : " + chatMember);
	}

	// 메시지 수신
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		String chatMember = (String) session.getAttributes().get("user");
		
		logger.info("{}로 부터 {}를 전달 받았습니다.", chatMember, message.getPayload());
		
		// Client 가 전송한 데이터 JSON -> Java Object
		Gson gson = new Gson();
		// JSON -> Java Object
		Message msg = gson.fromJson(message.getPayload(), Message.class);
		
		System.out.println(msg);
		// from , to , msg 

		// 전달 메시지 : Java Object -> JSON 으로 변경
		TextMessage sendMsg = new TextMessage(gson.toJson(msg));
		
		for (WebSocketSession webSocketSession : sessionList) {
			// 상대방에게 메시지 전달
			webSocketSession.sendMessage(sendMsg);
		}
		
		// 특정 대상에게 데이터 전송 : sessionMap에서 대상 WebSocketSession 찾아서 데이터를 전송 (1:1 메세지)
		String to = msg.getTo();
		WebSocketSession toSession = sessionMap.get(to);
		
		if(toSession != null) {
			toSession.sendMessage(sendMsg);
			// 데이터 베이스에 저장
		}
		
		// 자신에게 메시지 전달
		//session.sendMessage(sendMsg); 
		
	}

	

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		
		String chatMember = (String) session.getAttributes().get("user");
		// 접속 종료 회원의 WebSocketSession 삭제
		sessionList.remove(session);
		
		sessionMap.remove(chatMember);
		
		logger.info("{} 연결이 끊김", session.getId()+chatMember);
		System.out.println("채팅 퇴장 : " + chatMember);
	}

}
