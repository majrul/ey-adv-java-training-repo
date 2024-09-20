package com.ey.excepion;

public class ProductException extends RuntimeException {

	public ProductException() {
	}

	public ProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductException(String message) {
		super(message);
	}

	
}
