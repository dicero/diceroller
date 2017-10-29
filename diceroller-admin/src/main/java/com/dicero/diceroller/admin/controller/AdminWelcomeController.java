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

package com.dicero.diceroller.admin.controller;

import com.dicero.diceroller.access.AdminAccess;
import com.dicero.diceroller.access.AdminCookie;
import com.dicero.diceroller.access.AdminLoginer;
import com.dicero.diceroller.domain.enums.AdminRole;
import com.dicero.diceroller.domain.model.UserPlatformPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
public class AdminWelcomeController {
	private static final Logger logger = LoggerFactory.getLogger(AdminWelcomeController.class);


	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	@RequestMapping("/gettime")
	public @ResponseBody String gettime() {
		return "{\"time\":\""+new Date().getTime()+"\"}";
	}

	@AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
	@RequestMapping("/")
	public String welcome(AdminLoginer adminLoginValue, Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		logger.info("adminLoginValue=>"+adminLoginValue);
		return "welcome";
	}
	
	@RequestMapping("/set")
	public String welcomea(HttpSession httpSession,Map<String, Object> model) {
		UserPlatformPO userPlatform = new UserPlatformPO();
		userPlatform.setId(1L);
		userPlatform.setLoginUsername("hahha");
		userPlatform.setRole(AdminRole.ADMIN);
		AdminCookie.setLoginAdmin(httpSession, userPlatform);
		return "welcome";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String upload() {
		return "upload";
	}
	
	
//	@RequestMapping(value="/upload",method=RequestMethod.POST)
//	@ResponseBody public String upload(@RequestParam("file") MultipartFile file) {
////		String upfile = fileUpload.upload(file);
////		if(upfile != null){
////			return "upload ok. upfile => <a href=\"" + upfile + "\" target=\"_blank\">上传的图片</a>";
////		} else {
////			return "upload fail";
////		}
//	}
	
//	@Autowired FileUpload fileUpload;
	
}
