package com.dicero.diceroller.access;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.dicero.diceroller.common.util.DESUtil;
import com.dicero.diceroller.domain.model.UserPlatform;

/**   
* <p></p>
* @author ningzong.zeng
*/
public class AdminCookie {
	static String LOGIN_ADMIN_NAME = "001";
	 
	private static void setCookie(HttpSession httpSession, String value) {
		value = DESUtil.encode(value).trim();
		httpSession.setAttribute(LOGIN_ADMIN_NAME, value);
	}
	
	private static String getCookie(HttpSession httpSession) {
		Object loginAdminValue = httpSession.getAttribute(LOGIN_ADMIN_NAME);
		if(loginAdminValue == null) return null;
		return DESUtil.decode(loginAdminValue.toString());
	}
	
	public static void setLoginAdmin(HttpSession httpSession, UserPlatform userPlatform){
		String value = userPlatform.getId() + "," + userPlatform.getLoginUsername() + "," + userPlatform.getRole().name() + "," + userPlatform.getNickName();
		setCookie(httpSession, value);
	}
	
	public static void removeLoginAdmin(HttpSession httpSession){
		httpSession.removeAttribute(LOGIN_ADMIN_NAME);
	}
	
	public static AdminLoginer getLoginAdmin(HttpSession httpSession){
		String value = getCookie(httpSession);
		if(!StringUtils.isNotBlank(value)) return null;
		String[] v = value.split("\\,");
		return new AdminLoginer(Long.valueOf(v[0]), v[1], v[2], v[3]);
	}
}
