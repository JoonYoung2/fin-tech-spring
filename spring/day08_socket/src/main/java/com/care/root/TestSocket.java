package com.care.root;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TestSocket extends TextWebSocketHandler {
	
	//	static Map<String, String> map = new HashMap<>();
	//	static int cnt = 0;
	
	ArrayList<WebSocketSession> auth = new ArrayList<>();
	@Override // client가 연결시 실행되는 메소드 
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + "님 연결되었습니다.");
		
		auth.add(session);
	}

	@Override // 메세지 받는 메소드
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getId() + "님 메세지 ==> " + message.getPayload());
		
		Map<String, Object> map = session.getAttributes();
		
		System.out.println(session.getAttributes());
		
		TextMessage text = new TextMessage(map.get("nick")+" : "+message.getPayload());
		
		for(WebSocketSession s : auth) {
			s.sendMessage( text );
		}
	}

	@Override // 연결이 끊어지면 실행됨
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId() + "님 연결이 끊겼습니다.");
//		map.remove(session.getId());
	}
	
}
