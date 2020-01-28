package com.etm.entity;


public class Project {

	private String projectId;
	private String projectTitle;
	private String projectDescription;
	private String startDate;
	private String endDate;
	private String mgrId;
	private String projectCompPercentage;
	private String projectStatus;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String projectId, String projectTitle, String projectDescription, String startDate, String endDate,
			String mgrId, String projectCompPercentage, String projectStatus) {
		super();
		this.projectId = projectId;
		this.projectTitle = projectTitle;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mgrId = mgrId;
		this.projectCompPercentage = projectCompPercentage;
		this.projectStatus = projectStatus;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getMgrId() {
		return mgrId;
	}
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}
	public String getProjectCompPercentage() {
		return projectCompPercentage;
	}
	public void setProjectCompPercentage(String projectCompPercentage) {
		this.projectCompPercentage = projectCompPercentage;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle=" + projectTitle + ", projectDescription="
				+ projectDescription + ", startDate=" + startDate + ", endDate=" + endDate + ", mgrId=" + mgrId
				+ ", projectCompPercentage=" + projectCompPercentage + ", projectStatus=" + projectStatus + "]";
	}
	
	
	
	
	
}
