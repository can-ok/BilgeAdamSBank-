package com.bankb.bank.controller;


import com.bankb.bank.dao.TransactionDto;
import com.bankb.bank.service.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
public class Controller {


    @Autowired
    Operation operation;

    @GetMapping(path ="/")
    public String getBankAcount(){

        return "bankB";
    }

    @PostMapping(path ="/recive")
    public String Reciver(@RequestBody TransactionDto dao)
    {

        operation.handleTransfer(dao);
        System.out.println(dao.getAmount());
        return "Success";
    }

    @GetMapping(path = "/makeRequest")
    public void makeRequest(@RequestBody TransactionDto dao){

        operation.sendTransaction(dao);
    }
}
