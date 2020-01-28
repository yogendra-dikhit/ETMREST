package com.etm.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
			u = jdbcTemplate.queryForObject(query, new Object[] {user.getUserName(),user.getUserPassword()}, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {

					User user = new User();
					user.setUserName(rs.getString("user_name"));
					user.setUserPassword(rs.getString("user_password"));
					user.setEmpId(rs.getString("emp_id"));
					return null;
				}} );
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}

	
}
