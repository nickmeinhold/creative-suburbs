package com.creativesuburbs.prototype.server;

import javax.jdo.annotations.PersistenceCapable;

import java.util.Date;

import javax.jdo.annotations.Persistent;

import com.creativesuburbs.prototype.shared.ProjectDTO;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ProjectDAO {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    String id;
	
	@Persistent
    private Date dateCreated;
	@Persistent
	private int teamSize; 
	@Persistent
	private boolean financeHelp; 
	@Persistent
	private boolean govHelp; 
	@Persistent
	private String projectName; 
	@Persistent
	private String projectLocation; 
	@Persistent
	private String projectVerb; 
	@Persistent
	private String imageUrl; 
	@Persistent
	private String ownerId; 
	
	public ProjectDAO(ProjectDTO dto) 
	{
		this.dateCreated = new Date(); 
		
		this.teamSize = dto.getTeamSize(); 
		this.financeHelp = dto.isFinanceHelp(); 
		this.govHelp = dto.isGovHelp(); 
		this.projectName = dto.getProjectName(); 
		this.projectLocation = dto.getProjectLocation(); 
		this.projectVerb = dto.getProjectVerb(); 
		this.imageUrl = dto.getImageUrl(); 
		this.ownerId = dto.getOwnerId(); 
	}
	
	public ProjectDTO toDTO()
	{
		ProjectDTO dto = new ProjectDTO(); 
		
		dto.setTeamSize(this.teamSize); 
		dto.setFinanceHelp(this.financeHelp); 
		dto.setGovHelp(this.govHelp); 
		dto.setProjectName(this.projectName); 
		dto.setProjectLocation(this.projectLocation);
		dto.setProjectVerb(this.projectVerb);
		dto.setImageUrl(this.imageUrl);
		dto.setOwnerId(this.ownerId);
		
		return dto;
		
	}
	
	public String getId()
	{
		return id; 
	}
	
}
