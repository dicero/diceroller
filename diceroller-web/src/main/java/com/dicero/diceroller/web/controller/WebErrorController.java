package com.dicero.diceroller.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Controller
public class WebErrorController {
	@RequestMapping("/404")
	public String page_404() {
		return "error/404";
	}

    @RequestMapping("/403")
    public String page_403() {
        return "error/403";
    }

	@RequestMapping("/500")
	public String page_500() {
		return "error/500";
	}
}
