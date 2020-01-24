package com.etm.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.etm.entity.User;

@Repository
public class UserRepositoryImple implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public User findUser(User user) {
		User u = null;
		try {
			String query = "select * from User where user_name = ? and user_password = ?";
			u = jdbcTemplate.queryForObject(query, new Object[] {user.getUserName(),user.getUserPassword()},
			
			(rs,rowNum) -> new User(
					rs.getString("user_name"),
					rs.getString("user_password"),
					rs.getString("emp_id")
			));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}

	
}
