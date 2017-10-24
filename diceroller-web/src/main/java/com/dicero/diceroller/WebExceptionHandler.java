package com.dicero.diceroller;

import com.dicero.diceroller.common.bean.result.RestResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**   
* <p>全局异常</p>
* @author ningzong.zeng
*/
@ControllerAdvice
public class WebExceptionHandler {
	String DEFAULT_ERROR_VIEW = "error/exception";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
	public RestResponse defaultErrorHandler(HttpServletRequest req, Exception e) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", e);
//		mav.setViewName(DEFAULT_ERROR_VIEW);
		return RestResponse.createFailure(e.getMessage());
	}
    
    
}
