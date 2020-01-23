package com.etm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.etm.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

//	@Query("select e from Employee e where e.empId = ?1 ")
//	Employee findEmployee(String empId);
	
	
}