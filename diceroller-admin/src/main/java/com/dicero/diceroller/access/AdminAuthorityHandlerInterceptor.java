package com.dicero.diceroller.access;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dicero.diceroller.domain.enums.AdminRole;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 管理端权限拦截控制器
* <p></p>
* @author ningzhong.zeng
*
 */
public class AdminAuthorityHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			AdminAccess auth = ((HandlerMethod) handler).getMethodAnnotation(AdminAccess.class);
			if (auth != null) {
				AdminLoginer adminLoginer = AdminCookie.getLoginAdmin(request.getSession());
				if(adminLoginer!= null) {
					AdminRole[] adminRoles = auth.value();
					for (AdminRole adminRole: adminRoles) {
						if(adminLoginer.getRole().equals(adminRole.name())) {
							request.setAttribute("adminLoginer", adminLoginer);
							return super.preHandle(request, response, handler);
						}
					}
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
			response.sendRedirect("/auth/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		String encoding = "utf-8";
//		// 设置编码格式
//		response.setContentType("application/Json;charset=" + encoding);
//		response.setCharacterEncoding(encoding);
//		PrintWriter out = null;
//		try {
//			out = response.getWriter();
//			out.write("您没有权限");
//			out.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return false;
	}
}