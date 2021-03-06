package com.creativesuburbs.prototype.client.presenter;

import com.creativesuburbs.prototype.client.events.NavigationRequestEvent;
import com.creativesuburbs.prototype.client.view.ViewProjectView;
import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class ViewProjectPresenter {

	private ViewProjectView view; 
	private HasWidgets container; 
	private HandlerManager eventBus; 
	
	//private ProjectDTO projectDTO;  
	
	public ViewProjectPresenter(HasWidgets container, final HandlerManager eventBus)
	{
		this.container = container; 
		this.eventBus = eventBus; 
		
		this.view = new ViewProjectView(); 
		
		view.getBackToProjectsButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new NavigationRequestEvent("ViewStoredProjects"));
			}
			
		});
	}
	
	public void go(ProjectDTO projectDTO) 
	{
		container.clear();
		view.addProjectDetails(projectDTO); 
		container.add(view.asWidget()); 
	}
	
}
