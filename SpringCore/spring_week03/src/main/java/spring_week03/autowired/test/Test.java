package spring_week03.autowired.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_week03.autowired.model.Employee;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("spring_week03/autowired/test/config.xml");
		
		Employee emp=(Employee) context.getBean("employee");
		
		System.out.println(emp.toString());
	}

}
