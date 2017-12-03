package com.dicero.diceroller.service;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public class BaseService {

    @PersistenceContext EntityManager em;

    public static Timestamp now(){
        return new Timestamp(new Date().getTime());
    }

    @Transactional
    public boolean batchInsert(List list) {
        for(int i = 0; i < list.size(); i++) {
        }
        return true;
    }
}
