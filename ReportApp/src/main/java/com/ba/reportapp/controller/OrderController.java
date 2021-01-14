package com.ba.reportapp.controller;

import com.ba.reportapp.dto.OrderDto;
import com.ba.reportapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public List<OrderDto> getAllOrders(){

        try {
            return orderService.listOrders();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
