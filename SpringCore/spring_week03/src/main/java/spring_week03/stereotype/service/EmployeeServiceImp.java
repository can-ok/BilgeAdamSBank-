package spring_week03.stereotype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import spring_week03.stereotype.dao.EmployeeDAO;
import spring_week03.stereotype.model.Employee;


@Service(value="employeeServiceImpl")
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	public void saveEmployee(Employee emp) {
		System.out.println("Employee Service");
		
		employeeDAO.saveEmployee(emp);
	}
	
	

	

}
