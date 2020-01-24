package com.etm.cntr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etm.entity.Employee;
import com.etm.entity.User;
import com.etm.service.EmployeeService;
import com.etm.service.UserService;

@RestController
@CrossOrigin(allowedHeaders="*",
origins= {"http://localhost:4200"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/login",produces = {"application/json","application/xml"})
	public ResponseEntity<Employee> login(@RequestBody User user) {
		if( user != null && user.getUserName() != null && user.getUserPassword() != null ) {
		System.out.println(user.getUserName()+" "+user.getUserPassword());
	
		try{
			User u = userService.login(user);
			if( u != null ) {
				Employee emp =  employeeService.find(user);
				
				return new ResponseEntity<Employee>( emp,HttpStatus.OK) ;
			}
			
		}catch(Exception e) { e.printStackTrace();}

		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
