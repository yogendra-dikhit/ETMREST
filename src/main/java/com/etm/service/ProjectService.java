package com.etm.service;

import java.util.List;
import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;
import com.etm.entity.Response;

public interface ProjectService {

	void addProject(Project project);
	List<Project> getProjects();
	List<ProjectMembers> getEmployeeProjects(String empId);
	Response addmember(ProjectMembers projectMember);
	void updateProject(ProjectMembers projectMembers);
}
