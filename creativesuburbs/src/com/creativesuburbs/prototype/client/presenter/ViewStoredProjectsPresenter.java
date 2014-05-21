package com.creativesuburbs.prototype.client.presenter;

import java.util.List;

import com.creativesuburbs.prototype.client.view.ViewStoredProjectsView;
import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class ViewStoredProjectsPresenter {

	private ViewStoredProjectsView view; 
	private HasWidgets container; 
	private HandlerManager eventBus; 
	
	public ViewStoredProjectsPresenter(HasWidgets container, final HandlerManager eventBus)
	{
		this.container = container; 
		this.eventBus = eventBus; 
		
		this.view = new ViewStoredProjectsView(); 
		
		
	}
	
	public void go(List<ProjectDTO> projects) 
	{
		container.clear();
		view.clear(); 
		for(ProjectDTO dto : projects) {
			view.addProject(dto, eventBus); 
		}
		container.add(view.asWidget()); 
	}
	
}
