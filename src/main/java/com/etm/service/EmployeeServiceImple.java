package com.etm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etm.Dao.EmployeeRepository;
import com.etm.entity.Employee;
import com.etm.entity.User;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee find(User user) {
		
		Employee emp = null;
		if( user != null) {
			emp = employeeRepository.findEmployee(user);
		}
		
		return emp;
	}

	
}
