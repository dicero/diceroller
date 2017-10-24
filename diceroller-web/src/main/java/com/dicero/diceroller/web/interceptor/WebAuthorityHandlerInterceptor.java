package com.dicero.diceroller.web.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dicero.diceroller.web.hepler.HelperCookie;
import com.dicero.diceroller.web.hepler.WebLoginer;

/**
 * 管理端权限拦截控制器
* <p></p>
* @author ningzhong.zeng
*
 */
public class WebAuthorityHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			WebAccess auth = ((HandlerMethod) handler).getMethodAnnotation(WebAccess.class);
			if (auth != null) {
				WebLoginer webLoginer = HelperCookie.getLoginWeb(request);
				if(webLoginer != null) {
					return super.preHandle(request, response, handler);
				}
				return writerResponse(response);
			}
		}
		return super.preHandle(request, response, handler);
	}
	
	/**
	 * 
	 * <p>返回response，输出错误信息</p>
	 * @param response
	 * @param resultVO
	 * @return
	 * 
	 */
	public boolean writerResponse(HttpServletResponse response) {
		try {
			response.sendRedirect("/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}