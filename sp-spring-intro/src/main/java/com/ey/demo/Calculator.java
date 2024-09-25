package com.ey.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("calc") //alternative to <bean .. />
//@Scope("prototype")
public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}
}
