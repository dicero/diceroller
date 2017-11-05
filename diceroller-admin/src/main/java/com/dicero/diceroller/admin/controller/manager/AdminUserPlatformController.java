package com.dicero.diceroller.admin.controller.manager;

import com.dicero.diceroller.access.AdminAccess;
import com.dicero.diceroller.domain.enums.AdminRole;
import com.dicero.diceroller.domain.model.UserPlatformPO;
import com.dicero.diceroller.service.domain.UserPlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


/**   
* <p></p>
* @author ningzong.zeng
*/
@Controller
@RequestMapping(value="manager")
public class AdminUserPlatformController {
	Logger logger = LoggerFactory.getLogger(AdminUserPlatformController.class);
	int pageSize = 10;
	
	@Autowired
    UserPlatformService userPlatformService;
	
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform/list", method=RequestMethod.GET)
	public String userPlatformList(@RequestParam(value="page",defaultValue="1") int page, Model model) {
		Page<UserPlatformPO> userPlatforms = userPlatformService.findAll(page - 1, pageSize);
		model.addAttribute("userPlatforms", userPlatforms);
		return "userPlatform/list";
	}
	
	// 创建
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform", method=RequestMethod.GET)
	public String userPlatform(Model model) {
		model.addAttribute("userPlatformPO", new UserPlatformPO());
		model.addAttribute("adminRole", AdminRole.values());
		return "userPlatform/operate";
	}
	
	// 查看
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform/{id}", method=RequestMethod.GET)
	public String userPlatformOperate(@PathVariable String id, Model model) {
        UserPlatformPO userPlatform = this.userPlatformService.findById(Long.valueOf(id));
		model.addAttribute("userPlatformPO", userPlatform);
		model.addAttribute("adminRole", AdminRole.values());
		return "userPlatform/operate";
	}
	
	// 修改或者新增
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform/operate", method=RequestMethod.POST)
	public String userPlatformOperate(@Valid UserPlatformPO userPlatformPO,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("adminRole", AdminRole.values());
			return "userPlatform/operate";
		}
		if(userPlatformPO.getId() == null) {
			if(this.userPlatformService.save(userPlatformPO) == null){
				return "error/500";
			}
		} else {
			if(this.userPlatformService.update(userPlatformPO.getId(), userPlatformPO.getLoginUsername(), userPlatformPO.getLoginPassword(), userPlatformPO.getRole(),userPlatformPO.getNickName()) != 1) {
				return "error/500";
			}
		}
		return "redirect:/manager/userPlatform/list";
	}
	
}
