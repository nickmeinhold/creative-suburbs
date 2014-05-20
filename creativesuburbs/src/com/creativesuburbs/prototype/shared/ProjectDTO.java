package com.creativesuburbs.prototype.shared;

import java.io.Serializable;

public class ProjectDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int teamSize; 
	private boolean financeHelp; 
	private boolean govHelp; 
	private String projectName; 
	private String projectLocation; 
	private String projectVerb; 
	private String imageUrl; 
	private String ownerId; 
	
	public ProjectDTO() 
	{
		
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public boolean isFinanceHelp() {
		return financeHelp;
	}

	public void setFinanceHelp(boolean financeHelp) {
		this.financeHelp = financeHelp;
	}

	public boolean isGovHelp() {
		return govHelp;
	}

	public void setGovHelp(boolean govHelp) {
		this.govHelp = govHelp;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public String getProjectVerb() {
		return projectVerb;
	}

	public void setProjectVerb(String projectVerb) {
		this.projectVerb = projectVerb;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
	

}
