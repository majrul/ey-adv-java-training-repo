package com.ey.exception;

public class CustomerServiceException extends RuntimeException {

    public CustomerServiceException(String msg) {
        super(msg);
    }
}
