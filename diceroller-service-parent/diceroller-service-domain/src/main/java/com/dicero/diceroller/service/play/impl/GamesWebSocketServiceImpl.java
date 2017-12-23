package com.dicero.diceroller.service.play.impl;

import com.alibaba.fastjson.JSON;
import com.dicero.diceroller.common.bean.result.SocketEvent;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.bean.GamesWebSocket;
import com.dicero.diceroller.service.play.GamesWebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/23
 */
@Slf4j
@Service
public class GamesWebSocketServiceImpl extends BaseService implements GamesWebSocketService {
    private static CopyOnWriteArraySet<GamesWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    private static int onlineCount = 0;
    private static int LIMIT_ONLINE_COUNT = 200;

    @Override
    public boolean join(GamesWebSocket gamesWebSocket) {
        addOnlineCount();
        log.info("Games[加入]!当前在线人数为" + getOnlineCount());
        if (getOnlineCount() > LIMIT_ONLINE_COUNT) {
            return false;
        }
        webSocketSet.add(gamesWebSocket);
        return true;
    }

    @Override
    public boolean remove(GamesWebSocket gamesWebSocket) {
        subOnlineCount();
        log.info("Games[关闭]!当前在线人数为" + getOnlineCount());
        webSocketSet.remove(gamesWebSocket);
        return false;
    }

    public void sendNotify(String accessToken, SocketEvent socketEvent){
        try {
            for (GamesWebSocket item : webSocketSet) {
                if (item.getAccessToken().equals(accessToken)) {
                    item.getSession().getBasicRemote().sendText(JSON.toJSONString(socketEvent));
                }
            }
        } catch (Exception e) {
            log.error("sendNotify 失败, ", e);
        }
    }

    public static synchronized int getOnlineCount() {
        return GamesWebSocketServiceImpl.onlineCount;
    }

    public static synchronized void addOnlineCount() {
        GamesWebSocketServiceImpl.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        GamesWebSocketServiceImpl.onlineCount--;
    }
}
