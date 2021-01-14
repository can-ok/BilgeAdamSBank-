package com.banka.demo.service;


import com.banka.demo.dao.TransactionDto;
import com.banka.demo.entity.BankA;
import com.banka.demo.entity.Transactions;
import com.banka.demo.exception.InvalidAmount;
import com.banka.demo.repository.TransactionRepository;
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
        //transactions.setId(dto.getId());
        transactions.setReciverIban(dto.getReciverIban());
        transactions.setSenderIban(dto.getSenderIban());
        transactions.setAmount(dto.getAmount());

        transactionRepository.save(transactions);

    }


}
