package spring_week03.javabased.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring_week03.javabased.model.Employee;

@ComponentScan("spring_week03.javabased.model")
@Configuration
public class JavaBasedConfig {
	
	
	@Bean
	public Employee createEmployee() {
		Employee emp=new Employee("Can","Taşkıran",20,1);
		return emp;
		
	}
}
