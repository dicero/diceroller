package com.dicero.diceroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**   
* <p></p>
* @author ningzong.zeng
*/
@SpringBootApplication
@EnableAsync
public class TestApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestApplication.class, args);
	}

}

