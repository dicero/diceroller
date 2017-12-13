package com.dicero.diceroller.admin.controller.manager;

import com.dicero.diceroller.access.AdminAccess;
import com.dicero.diceroller.domain.enums.AdminRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/4
 */
@Slf4j
@Controller
@RequestMapping(value="/manager")
public class AdminIndexController {

    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index( Model model) {
        return "index/index";
    }

    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="/info", method=RequestMethod.GET)
    public String info( Model model) {
        return "index/info";
    }

    /** 修改或者新增 - 成功页面 */
    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="/iframe/success", method=RequestMethod.GET)
    public String success( Model model) {
        return "index/iframe-success";
    }

    /** 修改或者新增 - 失败页面 */
    @AdminAccess({AdminRole.SUPER_ADMIN, AdminRole.ADMIN})
    @RequestMapping(value="/iframe/failed", method=RequestMethod.GET)
    public String failed( Model model) {
        return "index/iframe-failed";
    }
}
