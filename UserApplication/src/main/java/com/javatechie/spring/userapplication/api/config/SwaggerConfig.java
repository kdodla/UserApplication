package com.javatechie.spring.userapplication.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/employee/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.javatechie"))
				.build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"Address book API",
				"Sample API for JavaBrains tutorial",
				"1.0",
				"Free to Use",
				new springfox.documentation.service.Contact("Kalpana Dodla", "", "kdodla1983@gmail.com"),
				"API License",
				"");
	}
}
