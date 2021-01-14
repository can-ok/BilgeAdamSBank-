package com.ba.reportapp.controller;


import com.ba.reportapp.dto.OrderItemsDto;
import com.ba.reportapp.dto.ResponseDto;
import com.ba.reportapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/orderItem")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3006"})
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;
    @GetMapping(path = "")
    public List<OrderItemsDto> getAllOrders(){

        try {
            return orderItemService.listOrders();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/topfive")
    public List<ResponseDto> getTopFive(){

        try {
            return orderItemService.getTopFiveProduct();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}
