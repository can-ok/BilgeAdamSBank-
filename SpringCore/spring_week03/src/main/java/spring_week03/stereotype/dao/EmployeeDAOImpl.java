package spring_week03.stereotype.dao;

import org.springframework.stereotype.Repository;

import spring_week03.stereotype.model.Employee;


@Repository(value="employeeDAOImpl")
//default ismi employeeDAOImpl
public class EmployeeDAOImpl implements EmployeeDAO {

	public void saveEmployee(Employee emp) {
		System.out.println("Employee DAO");

	}

}
