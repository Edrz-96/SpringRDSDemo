package com.qa.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	public String stuff() {
		return new String("stuff");
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
