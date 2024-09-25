package com.ey.demo.banking;

import org.springframework.stereotype.Component;

@Component
public class CitiBank implements Bank {

	@Override
	public boolean doesAccountExist(int acno) {
		return acno == 2222;
	}

	@Override
	public void communicate(String purpose) {
		System.out.println("Customer of CitiBank communicating for " + purpose);
	}
}