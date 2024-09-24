package com.ey.demo;

import org.springframework.stereotype.Component;

@Component("exchRateProv")
public class ExchangeRateProvider {

	public double currentValue(String from, String to) {
		if(from.equals("USD") && to.equals("INR"))
			return 83.61;
		else if(from.equals("GBP") && to.equals("INR"))
			return 111.92;
		else
			return -1;
	}
}
