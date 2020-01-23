package com.etm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etm.Dao.EmployeeRepository;
import com.etm.entity.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee find(String empId) {
		
		Employee emp = null;
		if( empId != null) {
			emp = employeeRepository.getOne(empId);
		}
		
		return emp;
	}

	
}
