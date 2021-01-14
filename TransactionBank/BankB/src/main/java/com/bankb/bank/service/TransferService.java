package com.bankb.bank.service;

import com.bankb.bank.dao.TransactionDto;
import com.bankb.bank.entity.Transactions;
import com.bankb.bank.exception.InvalidAmount;
import com.bankb.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    TransactionRepository transactionRepository;

    public Boolean checkAmount(TransactionDto dao){
        if(dao.getAmount()<1){
            throw new InvalidAmount("Invalid Amount: "+dao.getAmount());
        }
        return true;
    }


    public void insertTransaction(TransactionDto dto){

        Transactions transactions=new Transactions();
        transactions.setId(dto.getId());
        transactions.setReciverIban(dto.getReciverIban());
        transactions.setSenderIban(dto.getSenderIban());
        transactions.setAmount(dto.getAmount());

        transactionRepository.save(transactions);

    }
}
