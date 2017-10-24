package com.dicero.diceroller.web.websockets;

import com.alibaba.fastjson.JSON;
import com.dicero.diceroller.common.bean.result.SocketEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**   
* <p></p>
* @author zengningzong
*/
@ServerEndpoint("/websocket/test")  
@Component 
public class MyWebSocket {
	Logger logger = LoggerFactory.getLogger(MyWebSocket.class);
	private static int onlineCount = 0;

	private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

	private Session session;

	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSocketSet.add(this);
		addOnlineCount();
		logger.info("有新链接加入!当前在线人数为" + getOnlineCount());
	}

	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		subOnlineCount();
		logger.info("有一链接关闭!当前在线人数为" + getOnlineCount());
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		logger.info("来自客户端的消息:message=>" + message);
		try {
			SocketEvent socksEvent = (SocketEvent) JSON.parse(message);
			logger.info("来自客户端的消息:socksEvent=>" + socksEvent);
		} catch (Exception e) {
		}
		
		// 群发消息
		for (MyWebSocket item : webSocketSet) {
			item.sendMessage(message);
		}
	}

	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	public static synchronized int getOnlineCount() {
		return MyWebSocket.onlineCount;
	}

	public static synchronized void addOnlineCount() {
		MyWebSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		MyWebSocket.onlineCount--;
	}
}	
