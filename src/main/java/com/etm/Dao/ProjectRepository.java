package com.etm.Dao;

import java.util.List;

import com.etm.entity.Project;

public interface ProjectRepository {

	void createProject(Project proj);
	List<Project> getProjectList();
}
