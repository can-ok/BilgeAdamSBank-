package com.banka.demo.exception;

public class InvalidTransaction extends RuntimeException {

    public InvalidTransaction(String message) {
        super(message);
    }
}
