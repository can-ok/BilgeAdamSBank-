package com.ba.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ba.dto.Customer;

public class CustomerService {
	
	private static Map<Integer,Customer> customers=new HashMap<>();
	
	public boolean addCustomer(Customer customer) {
		if(customers.get(customer.getId())!=null) return false;
		customers.put(customer.getId(),customer);
		return true;
	}

	
	public Customer[] getAllCustomer() {
		Set<Integer> ids=customers.keySet();
		
		Customer[] c=new Customer[ids.size()];
		int i=0;
		for(Integer id:ids) {
			System.out.println(customers.get(id));
			c[i]=customers.get(id);
			i++;
		}
		
		return c;
	}
	
	public Customer getCustomer(int id) {
		return customers.get(id);
	}
	
}
