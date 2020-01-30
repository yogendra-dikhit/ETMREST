package com.etm.Dao;

import java.util.List;

import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;
import com.etm.entity.Response;

public interface ProjectRepository {

	void createProject(Project proj);
	List<Project> getProjects(String empId);
	Response addMember(ProjectMembers member);
}
