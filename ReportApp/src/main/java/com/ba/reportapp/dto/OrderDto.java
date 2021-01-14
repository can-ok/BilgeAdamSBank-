package com.ba.reportapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {


    private Integer id;

    private Integer totalPrice;

    private Date orderDate;

    private String paymentType;

    private String orderTable;

    private Integer waiterId;

    private Integer customerId;


}
