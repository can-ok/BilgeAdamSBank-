package com.banka.demo.exception;

public class AccountNotFound extends RuntimeException {

    public AccountNotFound(String message) {
        super(message);
    }
}
