package com.etm.service;

import java.util.List;

import com.etm.entity.Employee;
import com.etm.entity.User;
import com.etm.entity.newEmployee;

public interface EmployeeService {
	
	Employee find(User user);
	void addEmployee(newEmployee emp);
	List<Employee> findEmployees();
	List<Employee> findAllEmployees();
	void updateEmployee(Employee emp);
}
