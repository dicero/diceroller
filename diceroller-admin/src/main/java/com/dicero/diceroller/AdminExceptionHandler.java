package com.dicero.diceroller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**   
* <p>全局异常</p>
* @author ningzong.zeng
*/
@ControllerAdvice
public class AdminExceptionHandler {
	String DEFAULT_ERROR_VIEW = "error/exception";

    @ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
		// e.printStackTrace();

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
    
    
}
