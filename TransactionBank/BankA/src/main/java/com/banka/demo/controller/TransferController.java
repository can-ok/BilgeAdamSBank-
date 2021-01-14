package com.banka.demo.controller;

import com.banka.demo.dao.TransactionDto;
import com.banka.demo.service.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8081"})
public class TransferController {

    @Autowired
    Operation operation;

    @GetMapping(path ="/")
    public String getBankAcount(){

        return "bankA";
    }

    @GetMapping(path = "/makeRequest")
    public void makeRequest(@RequestBody TransactionDto dao){

        operation.sendTransaction(dao);
    }

    @PostMapping(path = "/recive")
    public String Reciver(@RequestBody TransactionDto dao){

        operation.handleTransfer(dao);
        System.out.println(dao.toString());

        return "Succes";
    }


}
