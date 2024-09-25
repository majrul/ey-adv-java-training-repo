package com.ey.demo.banking;

import org.springframework.stereotype.Component;

@Component
public class IciciBank implements Bank {

	@Override
	public boolean doesAccountExist(int acno) {
		return acno == 1111;
	}
	
	@Override
	public void communicate(String purpose) {
		System.out.println("Customer of IciciBank communicating for " + purpose);
	}
}
