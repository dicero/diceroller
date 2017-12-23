package com.dicero.diceroller.web.websockets;

import com.alibaba.fastjson.JSON;
import com.dicero.diceroller.common.bean.result.SocketEvent;
import com.dicero.diceroller.service.bean.GamesWebSocket;
import com.dicero.diceroller.service.bean.SpringUtils;
import com.dicero.diceroller.service.play.GamesWebSocketService;
import com.dicero.diceroller.service.tss.TssTradeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**   
* <p></p>
* @author znz
*/
@Slf4j
@ServerEndpoint("/games")
@Component 
public class Games {
    private GamesWebSocket gamesWebSocket;

    public TssTradeService getTssTradeService(){
        return SpringUtils.getBean(TssTradeService.class);
    }

    public GamesWebSocketService getGamesWebSocketService(){
        return SpringUtils.getBean(GamesWebSocketService.class);
    }


	@OnOpen
	public void onOpen(Session session) {
        Map<String, List<String>> requestParameterMap = session.getRequestParameterMap();
        if (MapUtils.isNotEmpty(requestParameterMap)) {
            List<String> stringList = requestParameterMap.get("access_token");
            if (CollectionUtils.isNotEmpty(stringList) && StringUtils.isNotBlank(stringList.get(0))) {
                if ( getTssTradeService().safeAccess(stringList.get(0)) ) {
                    this.gamesWebSocket = new GamesWebSocket(session, stringList.get(0));
                    getGamesWebSocketService().join(gamesWebSocket);
                }

            }
        }

	}

	@OnClose
	public void onClose() {
        if(gamesWebSocket != null) getGamesWebSocketService().remove(gamesWebSocket);
    }

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
        log.info("Games来自客户端的消息:message=>" + message);
		try {
			SocketEvent socksEvent = (SocketEvent) JSON.parse(message);
            log.info("Games来自客户端的消息:socksEvent=>" + socksEvent);
		} catch (Exception e) { }
		
	}

}
