package com.aop.demo.service;


import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String sendMessage(String param){
        System.out.println(param);

        return "Send Message: "+param;
    }
}
