package com.ey.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.demo.Calculator;
import com.ey.demo.HelloWorld;

public class App {

	public static void main(String[] args) {
		//Loading Spring framework / IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		//Access a bean
		HelloWorld hw = (HelloWorld) ctx.getBean("hello"); //bean id
		System.out.println(hw.sayHello());
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		
		//Why are are not creating object of HelloWorld class?
		//HelloWorld h = new HelloWorld();
		//Answer is pending
	}
}
