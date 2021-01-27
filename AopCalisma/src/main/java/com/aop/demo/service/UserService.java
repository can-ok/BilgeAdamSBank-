package com.aop.demo.service;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void showUser(String name){
        System.out.println("User:"+name);
    }
}
