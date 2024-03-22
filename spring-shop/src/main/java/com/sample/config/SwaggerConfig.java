package com.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
			.components(new Components())
			.info(apiInfo());
	}

	private Info apiInfo() {
		return new Info()
			.title("Spring-shop을 소개합니다.")
			.description("Springdoc을 사용한 Swagger UI입니다. 안녕ㅎㅎㅎㅎㅎㅎ나는 김다영이라고행~~~~~")
			.version("1.0.0");
	}
    
}