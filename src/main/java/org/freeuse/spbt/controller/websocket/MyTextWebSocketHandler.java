package org.freeuse.spbt.controller.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;



/**
 * websocket server
 * @author GeL
 *
 */
@Component
public class MyTextWebSocketHandler extends TextWebSocketHandler {
	
	//存放当前的连接
	public static List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
	
	/**
	 * 建立连接
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		super.afterConnectionEstablished(session);
		sessions.add(session);
	}

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	for(WebSocketSession user:MyTextWebSocketHandler.sessions){
    		if(!session.getId().equals(user.getId())){
    			user.sendMessage(message);
    		}
    	}
    }
    
    /**
     * 断开连接
     * @throws Exception 
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception{
    	super.afterConnectionClosed(session, closeStatus);
    	sessions.remove(session);
    }
}
