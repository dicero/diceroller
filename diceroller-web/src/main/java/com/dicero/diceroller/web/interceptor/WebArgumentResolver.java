package com.dicero.diceroller.web.interceptor;

import com.dicero.diceroller.web.hepler.HelperCookie;
import com.dicero.diceroller.web.hepler.WebLoginer;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 
* <p></p>
* @author ningzhong.zeng
*
 */
public class WebArgumentResolver implements HandlerMethodArgumentResolver {  
	
	@Override
	public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, NativeWebRequest webRequest,
			WebDataBinderFactory arg3) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        return HelperCookie.getLoginWeb(request);
    }

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(WebLoginer.class);
	}
}
