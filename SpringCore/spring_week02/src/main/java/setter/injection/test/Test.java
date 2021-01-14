package setter.injection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import setter.injection.model.Employee;

public class Test {

	public static void main(String[] args) {
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("file:src/main/config.xml");
		//file: preffix point to file system resources, not classpath.
		
		Employee employee=(Employee)context.getBean("employee");
		
		System.out.println(employee.toString());

	}

}
