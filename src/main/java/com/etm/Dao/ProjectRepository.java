package com.etm.Dao;

import java.util.List;

import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;

public interface ProjectRepository {

	void createProject(Project proj);
	List<Project> getProjects();
	void addMember(ProjectMembers member);
}
