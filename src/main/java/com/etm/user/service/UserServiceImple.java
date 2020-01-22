package com.etm.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etm.user.Dao.UserRepository;
import com.etm.user.entity.User;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean login(User user) {
	
		boolean auth = false;
		try {
			
			if( userRepository.findUser(user.getUserName(), user.getUserPassword()) != null )
				auth = true;
			
		}catch(Exception e) {
			
		}
		return auth;
	}

}
