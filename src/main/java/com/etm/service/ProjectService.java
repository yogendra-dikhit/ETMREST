package com.etm.service;

import java.util.List;
import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;

public interface ProjectService {

	void addProject(Project project);

	List<Project> getProjects();

	void addmember(ProjectMembers projectMember);
}
