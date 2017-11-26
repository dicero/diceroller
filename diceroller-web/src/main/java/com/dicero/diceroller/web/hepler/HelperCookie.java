package com.dicero.diceroller.web.hepler;

import com.dicero.diceroller.common.util.DESUtil;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**   
* <p>封装cookie</p>
* @author ningzong.zeng
*/
public class HelperCookie {
	public static Logger logger = LoggerFactory.getLogger(HelperCookie.class);
	public static String IMGET_CODE = "102";
	public static String MOBILE_CODE = "103";
	public static String SM_CODE = "104";
	public static String WEB_LOGIN = "105";
	
	public static void setCookie(HttpServletRequest request, String key, Object value) {
		if(StringUtils.isBlank(key) || value == null ) {
			logger.error("设置cookie失败,key=>{},value=>{}", key, value);
			return ;
		}
		try {
			value = DESUtil.encode(value.toString()).trim();
		} catch (Exception e) {
			logger.error("设置cookie失败,key=>{},value=>{}, err => {}", key, value, e);
		}
		 request.getSession().setAttribute(key, value);
	}
	
	public static String getCookie(HttpServletRequest request, String key) {
		if(StringUtils.isBlank(key) ) {
			logger.error("获取cookie失败,key=>{}", key);
			return null;
		}
		Object value = request.getSession().getAttribute(key);
		
		if(value == null) return null;
		try {
			return DESUtil.decode(value.toString());
		} catch (Exception e) {
			logger.error("获取cookie失败,key=>{},value=>{}, err => {}", key, value, e);
			return null;
		}
		
	}
	
	/** 设置登录的web账号 */
	public static void setLoginWeb(HttpServletRequest request, PersonalMemberPO user){
		String value = user.getMemberId() + "," + user.getMemberAccount();
		setCookie(request, WEB_LOGIN, value);
	}
	
	/** 登出 */
	public static void removeLoginWeb(HttpServletRequest request){
		request.getSession().removeAttribute(WEB_LOGIN);
	}
	
	/** 获取登录的web账号信息 */
	public static WebLoginer getLoginWeb(HttpServletRequest request){
		String value = getCookie(request, WEB_LOGIN);
		if(StringUtils.isBlank(value)) return null;
		String[] v = value.split("\\,");
		WebLoginer webLoginer = new WebLoginer(Integer.valueOf(v[0]), v[1]);
		return webLoginer;
	}
	
}
