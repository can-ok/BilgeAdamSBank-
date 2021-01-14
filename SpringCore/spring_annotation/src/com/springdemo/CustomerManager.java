package com.springdemo;

public class CustomerManager implements ICustomerService{
	
	
	private ICustomerDal customer;
	//constructure injection
	public CustomerManager(ICustomerDal customer)
	{
		this.customer=customer;
	}
	
	public void add()
	{
		customer.add();
	}

}
