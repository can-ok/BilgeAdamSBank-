package constructor.injection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import constructor.injection.model.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("file:src/main/constructor_config.xml");
		
		Employee emp=(Employee) context.getBean("emp");
		
		System.out.println(emp.toString());
		
	}

}
