package com.dicero.diceroller.service.dpm.impl;

import com.dicero.diceroller.service.dpm.DpmAccountDetailService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
@Service
public class DpmAccountDetailServiceImpl implements DpmAccountDetailService {

    @Async
    public Future<String> asyncRecordsDetail(String locagePoint) {

        return new AsyncResult<>("更新坐标缓存");
    }

}
