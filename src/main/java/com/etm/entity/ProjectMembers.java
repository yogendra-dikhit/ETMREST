package com.etm.entity;


public class ProjectMembers {

	private String empId;
	private String projectId;
	private String moduleId;
	private double evaluatedScore;
	private String moduleStatus;
	private int moduleMembersCount;
	public ProjectMembers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectMembers(String empId, String projectId, String moduleId, double evaluatedScore, String moduleStatus,
			int moduleMembersCount) {
		super();
		this.empId = empId;
		this.projectId = projectId;
		this.moduleId = moduleId;
		this.evaluatedScore = evaluatedScore;
		this.moduleStatus = moduleStatus;
		this.moduleMembersCount = moduleMembersCount;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public double getEvaluatedScore() {
		return evaluatedScore;
	}
	public void setEvaluatedScore(double evaluatedScore) {
		this.evaluatedScore = evaluatedScore;
	}
	public String getModuleStatus() {
		return moduleStatus;
	}
	public void setModuleStatus(String moduleStatus) {
		this.moduleStatus = moduleStatus;
	}
	public int getModuleMembersCount() {
		return moduleMembersCount;
	}
	public void setModuleMembersCount(int moduleMembersCount) {
		this.moduleMembersCount = moduleMembersCount;
	}
	
	
}
