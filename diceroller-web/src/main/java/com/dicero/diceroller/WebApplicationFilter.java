package com.dicero.diceroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**   
* <p></p>
* @author ningzong.zeng
*/
public class WebApplicationFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(WebApplicationFilter.class);
	static List<String> filterPath = new ArrayList<String>();
	
	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		paramFilterChain.doFilter(paramServletRequest, paramServletResponse);  
	}
	
	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
	
}
