package com.dicero.diceroller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**   
* <p></p>
* @author zengningzong
*/
@Configuration
public class WebSocketConfig {
	
	@Bean  
    public ServerEndpointExporter serverEndpointExporter (){  
        return new ServerEndpointExporter();  
    }
}
