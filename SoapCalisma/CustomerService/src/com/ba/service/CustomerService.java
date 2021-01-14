package com.ba.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ba.controller.CustomerController;
import com.ba.model.Customer;

public class CustomerService {
	
	private static Map<Integer,Customer> customers=new HashMap<>();
	
	CustomerController customerController=new CustomerController();
	
	public boolean addCustomer(Customer customer) {
		try {
			return customerController.create(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}
	
	
	public Boolean updateCustomer(Customer customer) {
		try {
			return customerController.update(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean deleteCustomer(int id) {
		try {
			return customerController.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	public Customer getCustomer(Customer customer) {
		
		try {
			return customerController.findById(customer.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}


	
	public List<Customer> getAllCustomer() {
	
		try {
			return customerController.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}
	
	
}
