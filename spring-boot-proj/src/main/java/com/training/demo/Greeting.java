package com.training.demo;

import java.time.LocalTime;

public class Greeting {

	public void greet() {
		LocalTime time = LocalTime.now();
		if(time.getHour() >= 4 && time.getHour() < 12)
			System.out.println("Good Morning!");
		else if(time.getHour() >= 12 && time.getHour() < 16)
			System.out.println("Good Afternoon!");
		else if(time.getHour() >= 16 && time.getHour() < 21)
			System.out.println("Good Evening!");
		else 
			System.out.println("Good Night!");
	}
	
	public static void main(String[] args) {
		Greeting g = new Greeting();
		g.greet();
	}
}
