package com.etm.Dao;

import java.util.List;

import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;
import com.etm.entity.Response;

public interface ProjectRepository {

	void createProject(Project proj);
	List<Project> getProjects();
	Response addMember(ProjectMembers member);
	List<ProjectMembers> getEmployeeProjects(String empId);
	void updateProject(ProjectMembers projectMembers);
}
