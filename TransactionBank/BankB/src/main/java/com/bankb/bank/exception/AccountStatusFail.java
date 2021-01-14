package com.bankb.bank.exception;

public class AccountStatusFail extends RuntimeException{
    public AccountStatusFail(String message) {
        super(message);
    }
}
