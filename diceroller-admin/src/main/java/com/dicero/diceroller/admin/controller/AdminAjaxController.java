package com.dicero.diceroller.admin.controller;

import com.dicero.diceroller.access.AdminAccess;
import com.dicero.diceroller.common.bean.result.ResultJson;
import com.dicero.diceroller.domain.enums.AdminRole;
import com.dicero.diceroller.service.domain.UserPlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**   
* <p></p>
* @author ningzong.zeng
*/
@RestController
@RequestMapping("/ajax")
public class AdminAjaxController {
	Logger logger = LoggerFactory.getLogger(AdminAjaxController.class);
	
	@Autowired
    UserPlatformService userPlatformService;
	
	/** 批量删除后台用户*/
	@AdminAccess({AdminRole.SUPER_ADMIN})
	@RequestMapping(value="/userPlatform/del", method=RequestMethod.POST)
	public ResultJson ajaxUserPlatformDel(@RequestParam(value="ids[]", required=true) List<Long> ids) {
		if(ids.size() != this.userPlatformService.deleteByIdIn(ids) ) return ResultJson.createFailed("删除失败", null);
		return ResultJson.createSuccess();
	}
	

	
	
}
