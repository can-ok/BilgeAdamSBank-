package com.ba.reportapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDto {

    private Integer Id;

    private Integer productId;

    private Integer productCount;


    private Integer productPrice;


    private Integer orderId;
}
