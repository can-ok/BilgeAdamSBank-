package com.bankb.bank.service;


import com.bankb.bank.dao.TransactionDto;
import com.bankb.bank.entity.BankB;
import com.bankb.bank.exception.AccountNotFound;
import com.bankb.bank.exception.AccountStatusFail;
import com.bankb.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private BankRepository bankRepository;



    public BankB findAccount(TransactionDto dto){

        Optional<BankB> byId = bankRepository.findById(dto.getReciverIban());

        if(!byId.isPresent()){
            throw new AccountNotFound("Account: "+dto.getReciverIban()+" not found");
        }
        return byId.get();
    }

    public BankB getSender(TransactionDto dto){

        Optional<BankB> byId = bankRepository.findById(dto.getSenderIban());

        if(!byId.isPresent()){
            throw new AccountNotFound("Account: "+dto.getReciverIban()+" not found");
        }
        return byId.get();
    }

    public Boolean accountStatus(BankB bankB){
        if (!bankB.getStatus()){
            throw  new AccountStatusFail("Account Status False");
        }

        return true;
    }

    public void updateAccountBalance(BankB bankB,TransactionDto dto){
        bankB.setTotal(bankB.getTotal()+dto.getAmount());

        bankRepository.save(bankB);
    }

    public void deductAccountBalance(BankB bankB,TransactionDto dto){
        bankB.setTotal(bankB.getTotal()-dto.getAmount());
        bankRepository.save(bankB);
    }

}
