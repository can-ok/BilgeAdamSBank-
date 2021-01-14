package com.ba.reportapp.service;

import com.ba.reportapp.dto.OrderDto;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderService {


    public List<OrderDto> listOrders() throws IOException {
        Reader reader = Resources.getResourceAsReader("batis-config.xml");
        SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(reader);
        try {
            return (List<OrderDto>) client.queryForList("order.getOrders");
        } catch (SQLException e) {
            System.out.println("DB işlemleri gerçekleşemedi! e:" + e);
        }

        return null;
    }




}
