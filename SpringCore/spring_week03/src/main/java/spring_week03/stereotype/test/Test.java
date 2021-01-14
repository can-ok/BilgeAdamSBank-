package spring_week03.stereotype.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_week03.stereotype.model.Employee;
import spring_week03.stereotype.service.EmployeeService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context=
				new ClassPathXmlApplicationContext("spring_week03/stereotype/test/config.xml");
		
			EmployeeService service=(EmployeeService) context.getBean("employeeServiceImpl");
			
			Employee emp=new Employee();
			emp.setAge(11);
			emp.setName("Can Okan");
			
			service.saveEmployee(emp);
	}

}
