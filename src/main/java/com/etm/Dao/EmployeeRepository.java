package com.etm.Dao;

import java.util.List;

import com.etm.entity.Employee;
import com.etm.entity.User;
import com.etm.entity.newEmployee;

public interface EmployeeRepository{


	Employee findEmployee(User user);
	void addEmployee(newEmployee emp);
	List<Employee> findEmployees();
	List<Employee> findAllEmployees();
	void updateEmp(Employee emp);
	
}