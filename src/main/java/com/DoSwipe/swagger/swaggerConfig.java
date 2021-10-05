package com.DoSwipe.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import java.util.Collection;
import java.util.Collections;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerConfig {
	@Bean
	public Docket createDocument()
	{
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(basePackage("com.DoSwipe.Contro"))
				.paths(PathSelectors.regex("/rest.*"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfo("My APP", "Product", "1.1", "http://www.google.com", new Contact("nilesh", "www.gmail.com", "123456789"), 
				"NIT", "www.gmail.com", Collections.EMPTY_LIST);
	}
}
