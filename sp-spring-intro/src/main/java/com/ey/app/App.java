package com.ey.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.config.MySpringConfig;
import com.ey.demo.Calculator;
import com.ey.demo.HelloWorld;
import com.ey.demo.LoginService;

public class App {

	public static void main(String[] args) {
		//Loading Spring framework / IoC container
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MySpringConfig.class);
		
		//Access a bean
		HelloWorld hw = (HelloWorld) ctx.getBean("hello"); //bean id
		System.out.println(hw.sayHello());
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		
		LoginService loginService = (LoginService) ctx.getBean("loginServ");
		System.out.println(loginService.isValidUser("majrul", "456"));
		
		//Why are are not creating object of HelloWorld class?
		//HelloWorld h = new HelloWorld();
		//Answer is pending
	}
}
