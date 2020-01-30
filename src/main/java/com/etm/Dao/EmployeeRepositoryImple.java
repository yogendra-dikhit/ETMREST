package com.etm.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.etm.entity.Employee;
import com.etm.entity.User;
import com.etm.entity.newEmployee;

@Repository
public class EmployeeRepositoryImple implements EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Employee findEmployee(User user) {
		Employee e = null;
		try {
			String query = "select * from Employee where emp_id = (select emp_id from user where user_name = ? and user_password = ?)";
			e = jdbcTemplate.queryForObject(query, new Object[] { user.getUserName(), user.getUserPassword()},new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = 
						
				new Employee(rs.getString("emp_id"),rs.getString("emp_name"),rs.getLong("emp_phone"),rs.getString("emp_email"),
						rs.getString("emp_doj"),rs.getDouble("emp_salary"),rs.getString("blood_type"),rs.getString("gender"),
						rs.getString("marital_status"),rs.getString("address"),rs.getString("role_name"),rs.getString("mgr_id"));
					return emp;
				}}				
			);

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(e);
		return e;
	}

	@Override
	@Transactional
	public void addEmployee(newEmployee emp) {

			String query = "call insertEmployee(?,?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(query, 
				new Object[] {emp.getEmpName(), emp.getEmpPhone(),emp.getEmpEmail(),emp.getEmpDoj(),
						emp.getEmpSalary(), emp.getBloodType(),emp.getGender(), emp.getMaritalStatus(),emp.getAddress(),emp.getRoleName(),emp.getMgrId()});
	
			jdbcTemplate.update("insert into user values(?,?,?)",emp.getUserName(), emp.getUserPassword(),emp.getEmpId());
	}

	@Override
	public List<Employee> findEmployees() {
		List<Employee> list = null;
		try {
			String query = "select * from Employee where role_name = 'Employee'";
			list = jdbcTemplate.query(query, new Object[] { },new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = 
						
				new Employee(rs.getString("emp_id"),rs.getString("emp_name"),rs.getLong("emp_phone"),rs.getString("emp_email"),
						rs.getString("emp_doj"),rs.getDouble("emp_salary"),rs.getString("blood_type"),rs.getString("gender"),
						rs.getString("marital_status"),rs.getString("address"),rs.getString("role_name"),rs.getString("mgr_id"));
					return emp;
				}}				
			);

		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return list;

	}

	@Override
	public void updateEmp(Employee emp) {

			String query = "update employee set emp_name = ? , emp_phone = ? , emp_email = ?, emp_doj = ?, "
					+ "emp_salary = ? , blood_type = ? , gender = ? , marital_status = ? , address = ? , role_name = ? where emp_id = ?";
			jdbcTemplate.update(query, 
				new Object[] { emp.getEmpName(), emp.getEmpPhone(),emp.getEmpEmail(),emp.getEmpDoj(),
						emp.getEmpSalary(), emp.getBloodType(),emp.getGender(), emp.getMaritalStatus(),emp.getAddress(),emp.getRoleName(), emp.getEmpId()});

		
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> list = null;
		try {
			String query = "select * from Employee";
			list = jdbcTemplate.query(query, new Object[] { },new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = 
						
				new Employee(rs.getString("emp_id"),rs.getString("emp_name"),rs.getLong("emp_phone"),rs.getString("emp_email"),
						rs.getString("emp_doj"),rs.getDouble("emp_salary"),rs.getString("blood_type"),rs.getString("gender"),
						rs.getString("marital_status"),rs.getString("address"),rs.getString("role_name"),rs.getString("mgr_id"));
					return emp;
				}}				
			);

		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

}
