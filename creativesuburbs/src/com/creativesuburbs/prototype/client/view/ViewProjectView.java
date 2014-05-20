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
import com.google.gwt.user.client.ui.SimplePanel;

public class ViewProjectView extends Composite {

	private static ViewProjectViewUiBinder uiBinder = GWT.create(ViewProjectViewUiBinder.class);
	
	@UiField Label projectNameLbl; 
	@UiField Image userImg;
	@UiField HTML userDescriptionHTML;
	@UiField SimplePanel projectImg;

	interface ViewProjectViewUiBinder extends UiBinder<Widget, ViewProjectView> {
	}

	public ViewProjectView() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	public void addProjectDetails(ProjectDTO dto)
	{
		String projectDescription = dto.getProjectName() + " in " + dto.getProjectLocation(); 
		setBannerDescription(projectDescription); 
		
		
		
	}
	
	public void setBannerDescription(String description) {
		
		projectNameLbl.setText(description);
		
	}

}
