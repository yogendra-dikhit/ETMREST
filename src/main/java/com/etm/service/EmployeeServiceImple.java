package com.etm.service;

import java.util.List;

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
		Employee emp = employeeRepository.findEmployee(user);
		return emp;
	}

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findEmployees() {
		List<Employee> list = employeeRepository.findEmployees();
		return list;
	}

	
}
