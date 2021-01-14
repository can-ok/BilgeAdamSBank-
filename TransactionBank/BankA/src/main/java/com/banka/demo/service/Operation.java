package com.banka.demo.service;

import com.banka.demo.dao.TransactionDto;
import com.banka.demo.entity.BankA;
import com.banka.demo.exception.AccountNotFound;
import com.banka.demo.exception.AccountStatusFail;
import com.banka.demo.exception.InvalidAmount;
import com.banka.demo.exception.InvalidTransaction;
import com.banka.demo.repository.BankRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.transaction.annotation.Transactional;

@Service
public class Operation {

    @Autowired
    TransferService transferService;

    @Autowired
    AccountService accountService;

    @Transactional(rollbackFor = {InvalidTransaction.class})
    public void sendTransaction(TransactionDto transactionDto){
        if(transferService.checkAmount(transactionDto)){

            transferService.insertTransaction(transactionDto);
            Map<String,String > response=sendRequest(transactionDto);

            int responseCode = Integer.parseInt(response.get("code"));
            if(responseCode==200){
                BankA bankA=accountService.getSender(transactionDto);

                accountService.deductAccountBalance(bankA,transactionDto);
            }
            else
            {
                throw new InvalidTransaction(response.get("message"));

            }
        }
    }

    @Autowired
    BankRepository bankRepository;

    public Map<String,String> sendRequest(TransactionDto transactionDto){

        Map<String,String> responseMap= new HashMap<>();

        OkHttpClient client=new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        String url="http://localhost:8081/recive";

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String obj = null;
        try {
            obj = mapper.writeValueAsString(transactionDto);

            RequestBody body=RequestBody.create(JSON,obj);

            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            try {
                Response response=client.newCall(request).execute();
                responseMap.put("code",String.valueOf(response.code()));

                responseMap.put("message",response.body().string());

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return responseMap;
    }



    @Transactional(rollbackFor = {AccountNotFound.class, AccountStatusFail.class, InvalidAmount.class})
    public void handleTransfer(TransactionDto dto){
        BankA bankA=accountService.findAccount(dto);

        if(!Objects.isNull(bankA) && transferService.checkAmount(dto)){

            transferService.insertTransaction(dto);

            if(accountService.accountStatus(bankA)){

                accountService.updateAccountBalance(bankA,dto);
            }
        }

    }


}
