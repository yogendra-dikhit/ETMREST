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
	public List<Project> getProjects() {
		List<Project> list = null;
		try {
			String query = "select * from project";
			list = jdbcTemplate.query(query,
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
					jdbcTemplate.queryForObject("select emp_id from project_members where project_id = ? and module_id = ?",new Object[] {member.getProjectId(), member.getModuleId()}, new RowMapper<ProjectMembers>() {
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

	@Override
	public List<ProjectMembers> getEmployeeProjects(String empId) {
		List<ProjectMembers> list = null;

		try {
			String query1 = "select * from project_members where emp_id = ?";
			list = jdbcTemplate.query(query1,
				new Object[] {empId}, new RowMapper<ProjectMembers>() {
				
					@Override
					public ProjectMembers mapRow(ResultSet rs, int rowNum) throws SQLException {

						ProjectMembers pro = new ProjectMembers();
						pro.setEmpId(rs.getString("emp_id"));
						pro.setProjectId(rs.getString("project_id"));
						pro.setModuleId(rs.getString("module_id"));
						pro.setEvaluatedScore(rs.getFloat("evaluated_score"));
						pro.setModuleStatus(rs.getString("module_status"));
						pro.setModuleMembersCount(rs.getInt("module_members_count"));
						return pro;
					}
				});

		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	@Override
	public void updateProject(ProjectMembers projectMembers) {
		String query = "call updateProjectMember(?,?,?,?)";
		jdbcTemplate.update(query 
			,projectMembers.getEmpId(), projectMembers.getProjectId(),projectMembers.getModuleId(),projectMembers.getModuleStatus());
		
	}

}
