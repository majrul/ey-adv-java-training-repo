package com.ey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ey.demo.HelloWorld;

@Configuration
@ComponentScan("com.ey.demo")
public class MySpringConfig {

	@Bean
	public HelloWorld hello() {
		return new HelloWorld();
	}
	
}
