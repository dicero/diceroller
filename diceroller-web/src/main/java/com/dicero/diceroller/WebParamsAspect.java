package com.dicero.diceroller;

import com.dicero.diceroller.common.util.ParamUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**   
* <p></p>
* @author ningzong.zeng
*/
@Aspect
@Component
@Order(-5)
public class WebParamsAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	/**
	 * 定义一个切入点. 解释下：
	 *
	 * ~ 第一个 * 代表任意修饰符及任意返回值. ~ 第二个 * 任意包名 ~ 第三个 * 代表任意方法. ~ 第四个 * 定义在web包或者子包 ~
	 * 第五个 * 任意方法 ~ .. 匹配任意数量的参数.
	 */
	@Pointcut("execution(public * com.dicero.diceroller.controller.*.*(..))")
	public void params() {
	}

	@Before("params()")
	public void doBefore(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		logger.info("Request: =================================");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("URL: " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD: " + request.getMethod());
		logger.info("IP: " + request.getRemoteAddr());
		logger.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
		logger.info("PARAMS: {}", ParamUtil.getBodyParam(request.getParameterMap()));
	}

	@AfterReturning("params()")
	public void doAfterReturning(JoinPoint joinPoint) {
		logger.info("Request End: 耗时 " + (System.currentTimeMillis() - startTime.get()) + "（毫秒） ===========");
	}
}
