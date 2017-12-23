package com.dicero.diceroller.service.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.websocket.Session;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/23
 */
@Data
@ToString
@AllArgsConstructor
public class GamesWebSocket {
    private Session session;
    private String accessToken;

}
