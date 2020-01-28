package com.etm.service;

import java.util.List;

import com.etm.entity.Employee;
import com.etm.entity.User;

public interface EmployeeService {
	
	Employee find(User user);
	void addEmployee(Employee emp);
	List<Employee> findEmployees();
}
