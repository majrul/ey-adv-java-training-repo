package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppLauncher {

	public static void main(String[] args) {
		SpringApplication.run(AppLauncher.class, args);
	}

}
