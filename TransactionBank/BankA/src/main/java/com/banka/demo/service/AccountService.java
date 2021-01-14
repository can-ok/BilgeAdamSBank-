package com.banka.demo.service;


import com.banka.demo.dao.TransactionDto;
import com.banka.demo.entity.BankA;
import com.banka.demo.exception.AccountNotFound;
import com.banka.demo.exception.AccountStatusFail;
import com.banka.demo.repository.BankRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private BankRepository bankRepository;


    public BankA findAccount(TransactionDto dto){

        Optional<BankA> bankA = bankRepository.findById(dto.getReciverIban());

        if(!bankA.isPresent()){
            throw new AccountNotFound("Account: "+dto.getReciverIban()+" not found");
        }

        return bankA.get();
    }

    public Boolean accountStatus(BankA bankA){
        if (!bankA.getStatus()){
            throw  new AccountStatusFail("Account Status False");
        }

        return true;
    }

    public void updateAccountBalance(BankA bankA,TransactionDto dto){
        bankA.setTotal(bankA.getTotal()+dto.getAmount());

        bankRepository.save(bankA);
    }


    public BankA getSender(TransactionDto dto){

        Optional<BankA> byId = bankRepository.findById(dto.getSenderIban());

        if(!byId.isPresent()){
            throw new AccountNotFound("Account: "+dto.getReciverIban()+" not found");
        }
        return byId.get();
    }

    public void deductAccountBalance(BankA bankA,TransactionDto dto){
        bankA.setTotal(bankA.getTotal()-dto.getAmount());
        bankRepository.save(bankA);
    }


}
