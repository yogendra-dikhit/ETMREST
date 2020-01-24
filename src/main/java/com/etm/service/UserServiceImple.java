package com.etm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etm.Dao.UserRepository;
import com.etm.entity.User;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(User user) {
	
		User u=null;
		try {
			u = userRepository.findUser(user);
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}

}
