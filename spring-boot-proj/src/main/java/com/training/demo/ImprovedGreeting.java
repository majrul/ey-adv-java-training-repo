package com.training.demo;

import java.time.LocalTime;

public class ImprovedGreeting {

	private LocalTime time;
	
	public ImprovedGreeting(LocalTime time) {
		this.time = time;
	}

	public void greet() {
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
		//LocalTime t = LocalTime.now();
		LocalTime t = LocalTime.of(12, 30);
		ImprovedGreeting g = new ImprovedGreeting(t);
		g.greet();
	}
}
