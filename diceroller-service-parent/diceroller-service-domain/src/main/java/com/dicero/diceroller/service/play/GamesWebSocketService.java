package com.dicero.diceroller.service.play;

import com.dicero.diceroller.common.bean.result.SocketEvent;
import com.dicero.diceroller.service.bean.GamesWebSocket;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/23
 */
public interface GamesWebSocketService {


    // NOTE: 加入
    boolean join(GamesWebSocket gamesWebSocket);

    // NOTE: 踢出
    boolean remove(GamesWebSocket gamesWebSocket);

    // NOTE: 发送
    void sendNotify(String accessToken, SocketEvent socketEvent);
}
