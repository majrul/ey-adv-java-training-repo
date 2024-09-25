package com.ey.demo.banking;

public interface Bank {

	public void communicate(String purpose);
	public boolean doesAccountExist(int acno);
}
