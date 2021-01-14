package com.banka.demo.exception;

public class InvalidAmount extends RuntimeException{

    public InvalidAmount(String message) {
        super(message);
    }
}
