package com.RMGYantra.GenericLib;

public class Pojoclass{
	
	String createdBy;
	String createdOn;
	String projectId;
	String ProjectName;
	String status;
	int teamSize;
	
	public Pojoclass(String createdBy, String projectName, String status,
			int teamSize) {
		super();
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.projectId = projectId;
		ProjectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
 
	
	

}

