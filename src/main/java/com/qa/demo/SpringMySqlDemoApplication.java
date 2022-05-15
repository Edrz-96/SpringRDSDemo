package com.qa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMySqlDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringMySqlDemoApplication.class, args);
//		System.out.println(context.getBean("stuff").hashCode());
//		String str = context.getBean(String.class);
//		System.out.println(str.hashCode());

	}

}
