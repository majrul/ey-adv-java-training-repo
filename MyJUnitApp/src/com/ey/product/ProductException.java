package com.ey.product;

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
