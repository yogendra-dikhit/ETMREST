package com.etm.cntr;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.etm.entity.Employee;
import com.etm.entity.Project;
import com.etm.entity.Response;
import com.etm.entity.User;
import com.etm.entity.newEmployee;
import com.etm.service.EmployeeService;
import com.etm.service.NotificationService;
import com.etm.service.ProjectService;
import com.etm.service.UserService;

@RestController
@CrossOrigin(
origins= {"http://localhost:4200"})
public class UserController {

	@Autowired
	private UserService userService;
	
 
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/login")
	public Employee login(@RequestBody User user) {
		Employee emp= null;
		User u =null;
		if( user != null && user.getUserName() != null && user.getUserPassword() != null ) {
		System.out.println(user.getUserName()+" "+user.getUserPassword());
		
		try{
			 //u = userService.login(user);
			
				emp =  employeeService.find(user);
				return emp;
				//return new ResponseEntity<Employee>( emp,HttpStatus.OK) ;
			
		}catch(Exception e) { e.printStackTrace();}

		}
		return emp;
		//return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/get-employees")
	public List<Employee> getEmployees(){
		
		List <Employee> list = employeeService.findEmployees();
		System.out.println(list);
		return list;
	}
	@GetMapping("/get-allEmployees")
	public List<Employee> getAllEmployees(){
		
		List <Employee> list = employeeService.findAllEmployees();
		System.out.println(list);
		return list;
	}
	@PutMapping("/update-employee")
	public Response updateEmp(@RequestBody Employee emp) {
		Response res = null;
		try {
			employeeService.updateEmployee(emp);
			return res = new Response("Updated");
		}catch (Exception e) {
			e.printStackTrace();
			res = new Response("Not Updated");
		}
		return res;
	}

	@PostMapping("/create-employee")
	public Response addEmployee(@RequestBody newEmployee emp) {
		Response res = null;
			try {
				employeeService.addEmployee(emp);

				res = new Response("Added Succefully");
			}catch(MailException m) {
				m.printStackTrace();
				res = new Response("Issue with Mail");
			}
			catch (Exception e) {
				e.printStackTrace();
				res = new Response("Not Added");
			}
		
		return res;
	}
}
