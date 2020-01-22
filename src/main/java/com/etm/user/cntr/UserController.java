package com.etm.user.cntr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etm.user.entity.User;
import com.etm.user.service.UserService;

@RestController
@CrossOrigin(allowedHeaders="*",
origins= {"http://localhost:4200"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login",produces = {"application/json"})
	public boolean login(@RequestBody User user) {
		System.out.println(user.getUserName()+" "+user.getUserPassword());
	

		if( userService.login(user) ) {
//			System.out.println(1);
			return true;
		}
		
		return false;
	}
}
