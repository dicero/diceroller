package com.dicero.diceroller;

import com.dicero.diceroller.web.interceptor.WebArgumentResolver;
import com.dicero.diceroller.web.interceptor.WebAuthorityHandlerInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import java.util.List;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebApplicationConfig extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer{
	
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public FilterRegistrationBean appFilter() {
        FilterRegistrationBean reg = new FilterRegistrationBean();
        reg.setFilter(new WebApplicationFilter());
        reg.addUrlPatterns("/*");
        return reg;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new WebAuthorityHandlerInterceptor() {
      });
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    	argumentResolvers.add(new WebArgumentResolver());
    }
    
    @Override
    public void customize(ConfigurableEmbeddedServletContainer factory) {
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
        factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/static/**")
	        .addResourceLocations("classpath:/static/")
	        .setCachePeriod(0);
    }
    
    @Bean(name = "velocityViewResolver")
    public VelocityLayoutViewResolver velocityViewResolver(VelocityProperties properties) {
        VelocityLayoutViewResolver resolver = new VelocityLayoutViewResolver();
        properties.applyToViewResolver(resolver);
        resolver.setLayoutUrl("layout/default.html");
        return resolver;
    }
}