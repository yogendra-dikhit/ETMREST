package com.etm.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etm.Dao.EmployeeRepository;
import com.etm.entity.Employee;
import com.etm.entity.User;
import com.etm.entity.newEmployee;

@Service
@Transactional
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	private NotificationService notificationService;
	
	@Override
	public Employee find(User user) {
		Employee emp = employeeRepository.findEmployee(user);
		return emp;
	}

	@Override
	public void addEmployee(newEmployee emp) {

		employeeRepository.addEmployee(emp);
		//notificationService.notify(emp);
		 
	}

	@Override
	public List<Employee> findEmployees() {
		List<Employee> list = employeeRepository.findEmployees();
		return list;
	}

	@Override
	public void updateEmployee(Employee emp) {
		employeeRepository.updateEmp(emp);;
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> list = employeeRepository.findAllEmployees();
		return list;
	}

	
}
