/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dicero.diceroller.web.controller;

import com.dicero.diceroller.web.interceptor.InterfaceType;
import com.dicero.diceroller.web.interceptor.WebAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

//import IEmail;

@Controller
public class WelcomeController {
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);


	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	

//	@Autowired IEmail iEmail;

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		logger.info("Hello "+ this.message);
		model.put("time", new Date());
		model.put("message", this.message);
		// iEmail.sendText("zengningzhong@souche.com", "sub", "test");
		return "welcome";
	}


	@RequestMapping("/index")
    @WebAccess(InterfaceType.PAGE)
	public String index(Map<String, Object> model) {
		return "view/index";
	}

    @RequestMapping("/play")
    public String play(Map<String, Object> model) {
        return "view/index";
    }

    @RequestMapping("/verify")
    @WebAccess(InterfaceType.PAGE)
    public String verify(Map<String, Object> model) {
        return "view/index";
    }


}
