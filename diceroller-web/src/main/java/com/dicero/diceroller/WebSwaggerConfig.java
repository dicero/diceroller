package com.dicero.diceroller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**   
* <p></p>
* @author zengningzong
*/
@Configuration
@EnableSwagger2
public class WebSwaggerConfig {
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.snail.barrage.web.rest"))
                .paths(PathSelectors.ant("/rest/**/*"))
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(
                		RequestMethod.GET, 
                		newArrayList(
                				new ResponseMessageBuilder()   
	                			      .code(500)
	                			      .message("500 message")
	                			      .responseModel(new ModelRef("Error"))
	                			      .build(),
                			    new ResponseMessageBuilder() 
	                			      .code(404)
	                			      .message("Not Found!")
	                			      .build(),
		                		new ResponseMessageBuilder() 
				      			      .code(403)
				      			      .message("Forbidden!")
				      			      .build()
				                ));
    }
	
	private List<ResponseMessage> newArrayList(ResponseMessage... responseMessages) {
		List<ResponseMessage> lists = new ArrayList<ResponseMessage>();
		for (ResponseMessage responseMessage : responseMessages) {
			lists.add(responseMessage);
		}
		return lists;
	}
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("服务器接口")
                //.description("Spring REST Sample with Swagger")
                //.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("")
                //.license("Apache License Version 2.0")
                //.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
