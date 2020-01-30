package com.etm.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etm.entity.Employee;
import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;
import com.etm.entity.Response;
import com.etm.service.ProjectService;

@RestController
@CrossOrigin(allowedHeaders="*",
origins= {"http://localhost:4200"})
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping(value = "/create-project",produces = {"application/json"})
	public ResponseEntity<Response> createPr(@RequestBody Project project) {
		
		if( project != null && project.getProjectId() != null && project.getProjectTitle() != null
			&& project.getStartDate() != null	&& project.getEndDate() != null && project.getProjectDescription() !=null 
			&& project.getMgrId() != null
			) {

			System.out.println(project);
		try{
			projectService.addProject(project);

			return new ResponseEntity<Response>( new Response("Project created")  , HttpStatus.OK) ;
		}catch(Exception e) { e.printStackTrace();}

		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/get-projectlist")
	public List<Project> getProjectList(){
		
		List <Project> list = projectService.getProjects();
		System.out.println(list);
		return list;
	}
	@GetMapping("/get-employee-projectlist")
	public List<ProjectMembers> getEmployeeProjectList(@RequestParam String empId){
		
		List <ProjectMembers> list = projectService.getEmployeeProjects(empId);
		System.out.println(list);
		return list;
	}
	
	@PostMapping("/add-projectmember")
	public ResponseEntity<Response> addmember(@RequestBody ProjectMembers projectMember) {
		
		if(projectMember != null && projectMember.getEmpId() != null && projectMember.getProjectId() != null &&
				projectMember.getModuleId() != null && projectMember.getModuleStatus() != null ) {
			System.out.println(projectMember);
			Response res =  projectService.addmember(projectMember);
			
			return new ResponseEntity<Response>( res , HttpStatus.OK) ;
		}
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/update-projectmember")
	public ResponseEntity<Response> updatemember(@RequestBody ProjectMembers projectMember) {
		System.out.println("in update");
		if(projectMember != null && projectMember.getEmpId() != null && projectMember.getProjectId() != null &&
				projectMember.getModuleId() != null && projectMember.getModuleStatus() != null ) {
			System.out.println(projectMember);
			projectService.updateProject(projectMember);
			System.out.println("updated");
			return new ResponseEntity<Response>( new Response("Updated") , HttpStatus.OK) ;
		}
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	

}