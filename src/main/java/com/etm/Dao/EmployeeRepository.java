package com.etm.Dao;

import com.etm.entity.Employee;
import com.etm.entity.User;

public interface EmployeeRepository{


	Employee findEmployee(User user);
	void addEmployee(Employee emp);
	
	
}