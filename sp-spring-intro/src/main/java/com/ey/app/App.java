package com.ey.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.config.MySpringConfig;
import com.ey.demo.Calculator;
import com.ey.demo.CurrencyConverter;
import com.ey.demo.HelloWorld;
import com.ey.demo.LoginService;
import com.ey.demo.TextEditor;

public class App {

	public static void main(String[] args) {
		//Loading Spring framework / IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(MySpringConfig.class);
		
		//Access a bean
		for(int i=0; i<5; i++) {
			HelloWorld hw = (HelloWorld) ctx.getBean("hello"); //bean id
			System.out.println(hw.sayHello());
		}
		
		/*Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		
		LoginService loginService = (LoginService) ctx.getBean("loginServ");
		System.out.println(loginService.isValidUser("majrul", "456"));
		
		CurrencyConverter cc = (CurrencyConverter) ctx.getBean("currConv");
		System.out.println(cc.convert("USD", "INR", 75));
		
		TextEditor te = (TextEditor) ctx.getBean("txtEdtr");
		te.load("abc.txt");*/
		
		//Why are are not creating object of HelloWorld class?
		//HelloWorld h = new HelloWorld();
		//Answer is pending
	}
}
