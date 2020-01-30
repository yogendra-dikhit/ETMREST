package com.etm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etm.Dao.ProjectRepository;
import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;
import com.etm.entity.Response;

@Service
public class ProjectServiceImple implements ProjectService{

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public void addProject(Project project) {
	
		try {
			projectRepository.createProject(project);
		}catch(Exception e){e.printStackTrace();}
	}

	@Override
	public List<Project> getProjects(String empId) {
		List<Project> list = projectRepository.getProjects(empId);
		return list;
	}

	@Override
	public Response addmember(ProjectMembers projectMember) {
		Response res =  projectRepository.addMember(projectMember);
		return res;
		
	}

}
