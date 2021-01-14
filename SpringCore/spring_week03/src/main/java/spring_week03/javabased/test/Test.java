package spring_week03.javabased.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring_week03.javabased.config.JavaBasedConfig;
import spring_week03.javabased.model.Employee;

public class Test {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(JavaBasedConfig.class);
		//context.register(componentClasses); reigster'da edebiliriz
		
		Employee emp=context.getBean(Employee.class);
		
		System.out.println(emp.toString());
	} 

	

}
