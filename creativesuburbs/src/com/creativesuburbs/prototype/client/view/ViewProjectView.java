package com.creativesuburbs.prototype.client.view;

import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Button;

public class ViewProjectView extends Composite {

	private static ViewProjectViewUiBinder uiBinder = GWT.create(ViewProjectViewUiBinder.class);
	
	@UiField Label projectNameLbl; 
	@UiField Image userImg;
	@UiField HTML userDescriptionHTML;
	@UiField Image projectImg;
	@UiField Button backToProjectsButton;

	interface ViewProjectViewUiBinder extends UiBinder<Widget, ViewProjectView> {
	}

	public ViewProjectView() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	public void addProjectDetails(ProjectDTO dto)
	{
		String projectDescription = dto.getProjectName() + " in " + dto.getProjectLocation(); 
		setBannerDescription(projectDescription); 
		setUserDescription(" wants to "+dto.getProjectVerb()+ " a " + projectDescription);
		setProjectImage(dto.getImageUrl()); 
	}
	
	private void setBannerDescription(String description) {
		
		projectNameLbl.setText(description);
		
	}
	
	private void setUserDescription(String description)
	{
		userDescriptionHTML.setHTML(description); 
	}
	
	private void setProjectImage(String url)
	{
		this.projectImg.setUrl(url);
	}
	
	public Button getBackToProjectsButton()
	{
		return this.backToProjectsButton; 
	}

}
