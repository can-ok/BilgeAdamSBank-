package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(IocConfig.class);		
		
		
		ICustomerService service=context.getBean("service",ICustomerService.class);
		
		service.add();
		
	}

}
