package com.dicero.diceroller.admin.controller;

import com.dicero.diceroller.access.AdminCookie;
import com.dicero.diceroller.domain.model.UserPlatformPO;
import com.dicero.diceroller.service.domain.UserPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Controller
@RequestMapping(value="auth")
public class AdminAuthController {
	
	@Autowired
	UserPlatformService userPlatformService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet(Model model) {
		model.addAttribute("userPlatformPO", new UserPlatformPO());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(HttpSession httpSession, @Valid UserPlatformPO userPlatformPO, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "login";
		}
		UserPlatformPO login = this.userPlatformService.login(userPlatformPO.getLoginUsername(), userPlatformPO.getLoginPassword());
		if(login!=null) {
			AdminCookie.setLoginAdmin(httpSession, login);
			return "redirect:/manager/index";
		}
		model.addAttribute("error", "登录失败");
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {
		AdminCookie.removeLoginAdmin(httpSession);
		return loginGet(model);
	}
}
