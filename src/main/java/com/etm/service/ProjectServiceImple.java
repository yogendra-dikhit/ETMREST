package com.etm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etm.Dao.ProjectRepository;
import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;

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
	public List<Project> getProjects() {
		List<Project> list = projectRepository.getProjects();
		return list;
	}

	@Override
	public void addmember(ProjectMembers projectMember) {
		projectRepository.addMember(projectMember);
		
	}

}
