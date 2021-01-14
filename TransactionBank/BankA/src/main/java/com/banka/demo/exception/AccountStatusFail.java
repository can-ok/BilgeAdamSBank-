package com.banka.demo.exception;

public class AccountStatusFail  extends RuntimeException{
    public AccountStatusFail(String message) {
        super(message);
    }
}
