package com.dicero.diceroller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

/**   
* <p></p>
* @author zengningzong
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestApplication.class)
public class TestBase {

    public static Timestamp now = new Timestamp(new Date().getTime());

    public void println(Object o){
        System.out.println("============================================> ");
        System.out.println("Result => " + o);
        System.out.println("============================================> ");
    }
}

