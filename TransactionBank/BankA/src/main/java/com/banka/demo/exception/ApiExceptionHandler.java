package com.banka.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {AccountStatusFail.class})
    public ResponseEntity<Object> userStatusFalse(AccountStatusFail e){
        //HttpStatus badRequest= HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidTransaction.class})
    public ResponseEntity<Object> invalidTransaction(InvalidTransaction e){
        //HttpStatus badRequest= HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {AccountNotFound.class})
    public ResponseEntity<Object> accountNotFound(AccountNotFound e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidAmount.class})
    public ResponseEntity<Object> invalidAmount(InvalidAmount e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
