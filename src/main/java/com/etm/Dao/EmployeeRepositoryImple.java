package com.etm.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.etm.entity.Employee;
import com.etm.entity.User;

@Repository
public class EmployeeRepositoryImple implements EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Employee findEmployee(User user) {
		Employee e = null;
		try {
			String query = "select * from Employee where emp_id = (select emp_id from user where user_name = ? and user_password = ?)";
			e = jdbcTemplate.queryForObject(query, new Object[] { user.getUserName(), user.getUserPassword()},
			
			(rs,rowNum) -> new Employee(
					rs.getString("emp_id"),
					rs.getString("emp_name"),
					rs.getLong("emp_phone"),
					rs.getString("emp_email"),
					rs.getString("emp_doj"),
					rs.getDouble("emp_salary"),
					rs.getString("blood_type"),
					rs.getString("gender"),
					rs.getString("marital_status"),
					rs.getString("address"),
					rs.getString("role_name"),
					rs.getString("mgr_id")
			));

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(e);
		return e;
	}

	@Override
	public void addEmployee(Employee emp) {
		try {
			String query = "insert into Employee values(?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(query, 
				new Object[] { emp.getEmpName(), emp.getEmpPhone(),emp.getEmpEmail(),emp.getEmpDoj(),
						emp.getEmpSalary(), emp.getBloodType(),emp.getGender(), emp.getMaritalStatus(),emp.getAddress(),emp.getRoleName()});

		}catch(Exception ex) {
			ex.printStackTrace();
		}		
	}

}
