package com.dicero.diceroller.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.dicero.diceroller.common.bean.result.RestCode;
import com.dicero.diceroller.common.bean.result.RestResponse;
import com.dicero.diceroller.web.hepler.HelperCookie;
import com.dicero.diceroller.web.hepler.WebLoginer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 管理端权限拦截控制器
* <p></p>
* @author ningzhong.zeng
*
 */
@Slf4j
public class WebAuthorityHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			WebAccess auth = ((HandlerMethod) handler).getMethodAnnotation(WebAccess.class);
			if (auth != null) {

			    // FIXME: 测试写死账号
                WebLoginer webLoginer = HelperCookie.getLoginWeb(request);
				if(webLoginer != null) {
					return super.preHandle(request, response, handler);
				}
                if (auth.value().equals(InterfaceType.REST)) {
                    write(response, JSON.toJSONString(RestResponse.createFailure(RestCode.USER_NOT_LOGIN)), "application/json");
                    return false;
                }
                return  writerResponse(response);
			}
		}
		return super.preHandle(request, response, handler);
	}
	
	/**
	 * 
	 * <p>返回response，输出错误信息</p>
	 * @param response
	 * @return
	 * 
	 */
	public boolean writerResponse(HttpServletResponse response) {
		try {
			response.sendRedirect("/play");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

    private final static String DEFAULT_ENCODING = "UTF-8";
    public static void write(HttpServletResponse response, String data, String contentType){
        OutputStream os = null;

        try {
            if (StringUtils.hasText(data)) {
                os = response.getOutputStream();
                response.setCharacterEncoding(DEFAULT_ENCODING);
                response.setContentType(contentType);
                os.write(data.getBytes(DEFAULT_ENCODING));
                os.flush();
            }
        } catch (Exception ex) {
            log.error("write data to response error", ex);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("close OutputStream error", e);
                }
            }
        }
    }
}