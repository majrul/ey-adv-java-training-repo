package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.abc.component")
public class AppLauncher {

	public static void main(String[] args) {		
		SpringApplication.run(AppLauncher.class);
	}
}