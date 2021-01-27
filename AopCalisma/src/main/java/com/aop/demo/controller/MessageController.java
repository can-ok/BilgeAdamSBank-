package com.aop.demo.controller;


import com.aop.demo.dto.UserDto;
import com.aop.demo.service.MessageService;
import com.aop.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> postMsg(@RequestBody UserDto user){
        userService.showUser(user.getName());
        return ResponseEntity.ok(messageService.sendMessage(user.getMessage()));
    }
}
