package com.etm.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.etm.entity.Project;
import com.etm.entity.ProjectMembers;
import com.etm.entity.Response;

@Repository
public class ProjectRepositoryImple implements ProjectRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createProject(Project proj) {

			String query = "insert into Project values(?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(query 
				,proj.getProjectId(), proj.getProjectTitle(), proj.getProjectDescription(),proj.getStartDate(),proj.getEndDate(),proj.getMgrId(),proj.getProjectCompPercentage(),proj.getProjectStatus() );
	}

	@Override
	public List<Project> getProjects(String empId) {
		List<Project> list = null;
		try {
			String query = "select * from project where mgr_id = ?";
			list = jdbcTemplate.query(query,
				new Object[] {empId}, new RowMapper<Project>() {
				
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
						pro.setProjectStatus(rs.getString("project_status"));
						
						return pro;
					}
				});

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Response addMember(ProjectMembers member) {
		Response res = null;
		try {
			ProjectMembers pmember =
					jdbcTemplate.queryForObject("select emp_id from project_members where project_id = 'p_09' and module_id = 'M100'",new Object[] {}, new RowMapper<ProjectMembers>() {
				@Override
				public ProjectMembers mapRow(ResultSet rs, int rowNum) throws SQLException {
					ProjectMembers pmember = new ProjectMembers();
					pmember.setEmpId(rs.getString("emp_id"));
					return pmember;
				}});
			System.out.println(pmember);
		} catch (Exception e) {
			String query = "call insertProjectMember(?,?,?,?,?)";
			jdbcTemplate.update(query, member.getEmpId() , member.getProjectId(),
					member.getModuleId(), member.getEvaluatedScore() , member.getModuleStatus() 
				 );
			return res = new Response("Member Added");
		}
		return res;
		


	}

}
