package com.etm.service;

import com.etm.entity.Employee;
import com.etm.entity.User;

public interface EmployeeService {
	
	Employee find(User user);
}
