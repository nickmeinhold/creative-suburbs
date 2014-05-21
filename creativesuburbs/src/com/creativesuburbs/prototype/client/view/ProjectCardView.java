package com.creativesuburbs.prototype.client.view;

import com.creativesuburbs.prototype.client.events.NavigationRequestEvent;
import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;

public class ProjectCardView extends Composite {

	private static ProjectCardViewUiBinder uiBinder = GWT.create(ProjectCardViewUiBinder.class);
	
	@UiField Label projectName;
	@UiField Image projectImg;

	interface ProjectCardViewUiBinder extends UiBinder<Widget, ProjectCardView> {
	}

	public ProjectCardView(final ProjectDTO projectDTO, final HandlerManager eventBus) {
		initWidget(uiBinder.createAndBindUi(this));
		this.projectName.setText(projectDTO.getProjectName()+" in "+projectDTO.getProjectLocation());
		this.projectImg.setUrl(projectDTO.getImageUrl()); 
		
		this.projectImg.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new NavigationRequestEvent("ViewProject", projectDTO)); 
			}
			
		}); 
	}

}
