package com.ey.demo;

import org.springframework.stereotype.Component;

@Component("calc") //alternative to <bean .. />
public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}
}
