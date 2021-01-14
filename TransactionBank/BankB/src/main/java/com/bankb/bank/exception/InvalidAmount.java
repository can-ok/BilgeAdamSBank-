package com.bankb.bank.exception;

public class InvalidAmount extends RuntimeException{
    public InvalidAmount(String message) {
        super(message);
    }
}
