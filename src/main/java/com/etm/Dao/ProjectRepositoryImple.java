package com.etm.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.etm.entity.Project;

public class ProjectRepositoryImple implements ProjectRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createProject(Project proj) {
		try {
			String query = "insert into Project values(?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(query, 
				new Object[] { proj.getProjectId(), proj.getProjectTitle(), proj.getProjectDescription(),proj.getStartDate(),proj.getEndDate(),proj.getMgrId(),proj.getProjectCompPercentage(),proj.getProjectStatus() });

		}catch(Exception ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public List<Project> getProjectList() {
		List<Project> list = null;
		try {
			String query = "select * from project";
			jdbcTemplate.queryForList(query,
				new Object[] {}, new RowMapper<Project>() {

					@Override
					public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

						Project pro = new Project();
						pro.setProjectId(rs.getString("project_id"));
						pro.setProjectTitle(rs.getString("project_title"));
						pro.setProjectDescription(rs.getString("project_description"));
						pro.setStartDate(rs.getString("start_date"));
						pro.setEndDate(rs.getString( "end_date"));
						pro.setMgrId(rs.getString("mgr_id"));
						pro.setProjectCompPercentage(rs.getString("project_comp_percentage"));
						pro.setProjectId(rs.getString("project_status"));
						
						return pro;
					}
				});

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

}
