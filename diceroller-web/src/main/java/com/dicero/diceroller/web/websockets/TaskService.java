package com.dicero.diceroller.web.websockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**   
* <p></p>
* @author zengningzong
*/
@Component
public class TaskService {
	Logger logger = LoggerFactory.getLogger(TaskService.class);
	
	@Async
	public Future<String> updateLocageCache(String locagePoint) {
		return new AsyncResult<>("更新坐标缓存");
	}
	
	
}
