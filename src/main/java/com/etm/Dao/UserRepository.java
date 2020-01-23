package com.etm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.etm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("select u from User u where u.userName = ?1 and u.userPassword = ?2")
	User findUser(String userName, String userPassword);
	
	
}
