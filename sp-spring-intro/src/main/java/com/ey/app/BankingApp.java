package com.ey.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.config.BankingAppConfig;
import com.ey.config.MySpringConfig;
import com.ey.demo.Calculator;
import com.ey.demo.CurrencyConverter;
import com.ey.demo.HelloWorld;
import com.ey.demo.LoginService;
import com.ey.demo.TextEditor;
import com.ey.demo.banking.Atm;

public class BankingApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BankingAppConfig.class);

		Atm atm = ctx.getBean(Atm.class);
		atm.withdraw(2222, 5000);
	}
}
