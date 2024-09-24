package com.ey.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("currConv")
public class CurrencyConverter {
	
	//DI
	@Autowired //alternative to getBean(..) method
	private ExchangeRateProvider exchangeRateProvider;

	public double convert(String from, String to, double amount) {
		if(from.equals("USD") && to.equals("INR"))
			return amount * exchangeRateProvider.currentValue(from, to);
		else if(from.equals("GBP") && to.equals("INR"))
			return amount * exchangeRateProvider.currentValue(from, to);
		else 
			return -1; //rather throw an exception
	}
}
