package com.ey.demo.banking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SbiAtm implements Atm {

	@Autowired
	private List<Bank> banks;
	
	@Override
	public void withdraw(int acno, double amount) {
		System.out.println("Customer at SbiAtm wants to withdraw money..");
		Bank currentBank = null;
		for(Bank bank : banks) {
			if(bank.doesAccountExist(acno)) {
				currentBank = bank;
				break;
			}
		}
		currentBank.communicate("withdraw");
	}

	/*@Autowired
	private Bank bank;
	
	@Override
	public void withdraw(int acno, double amount) {
		System.out.println("Customer at SbiAtm wants to withdraw money..");
		bank.communicate("withdraw");
	}*/

}
