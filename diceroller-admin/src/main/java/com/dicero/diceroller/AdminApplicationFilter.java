package com.dicero.diceroller;

import javax.servlet.*;
import java.io.IOException;

/**   
* <p></p>
* @author ningzong.zeng
*/
public class AdminApplicationFilter implements Filter{
	// private static final Logger logger = LoggerFactory.getLogger(BarrageAdminApplicationFilter.class);
	
	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		// logger.debug("=======doFilter=============");
		paramFilterChain.doFilter(paramServletRequest, paramServletResponse);  
	}
	
	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
	
}
