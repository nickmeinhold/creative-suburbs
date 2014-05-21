package com.creativesuburbs.prototype.client;

import java.util.List;

import com.creativesuburbs.prototype.client.events.NavigationRequestEvent;
import com.creativesuburbs.prototype.client.events.NavigationRequestEventHandler;
import com.creativesuburbs.prototype.client.presenter.LandingPagePresenter;
import com.creativesuburbs.prototype.client.presenter.PostProjectPresenter;
import com.creativesuburbs.prototype.client.presenter.ViewProjectPresenter;
import com.creativesuburbs.prototype.client.presenter.ViewStoredProjectsPresenter;
import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class AppController {

	private HandlerManager eventBus;
	private CreativeSuburbsServiceAsync projectsService; 
	private LandingPagePresenter landingPagePresenter;
	private PostProjectPresenter postProjectPresenter;
	private ViewProjectPresenter viewProjectPresenter;
	private ViewStoredProjectsPresenter viewStoredProjectsPresenter;
	
	public AppController(CreativeSuburbsServiceAsync projectsService, HandlerManager eventBus)
	{
		this.eventBus = eventBus; 
		this.projectsService = projectsService; 
		
		landingPagePresenter = new LandingPagePresenter(RootLayoutPanel.get(), eventBus); 
		postProjectPresenter = new PostProjectPresenter(RootLayoutPanel.get(), eventBus); 
		viewProjectPresenter = new ViewProjectPresenter(RootLayoutPanel.get(), eventBus); 
		viewStoredProjectsPresenter = new ViewStoredProjectsPresenter(RootLayoutPanel.get(), eventBus); 
		
		bind(); 
		
	}
	
	public void go() 
	{
		
		landingPagePresenter.go(); 
		
	}
	
	private void bind() {
	    //History.addValueChangeHandler(this); 
		
		eventBus.addHandler(NavigationRequestEvent.TYPE, new NavigationRequestEventHandler() {

			@Override
			public void onMessageReceived(final NavigationRequestEvent event) {
				
				if(event.getToPage().equals("PostProject")) 
				{
					postProjectPresenter.go();
				}
				else if(event.getToPage().equals("ViewStoredProjects"))
				{
					RootLayoutPanel.get().clear(); 
					RootLayoutPanel.get().add(new HTML("Retrieving Projects..."));
					
					projectsService.retrieveAllProjects(new AsyncCallback<List<ProjectDTO>>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO - should add something here to allow for better error handling 
							RootLayoutPanel.get().add(new HTML("Error retrieving projects."));
						}

						@Override
						public void onSuccess(List<ProjectDTO> result) {
							viewStoredProjectsPresenter.go(result);
						}
						
					});
					
				}
				else if(event.getToPage().equals("ViewProject")) 
				{
					RootLayoutPanel.get().clear(); 
					viewProjectPresenter.go(event.getProjectDTO());
					
				}
				else if(event.getToPage().equals("StoreAndViewProject")) 
				{
					RootLayoutPanel.get().clear(); 
					RootLayoutPanel.get().add(new HTML("Storing Project..."));
					
					projectsService.storeProject(event.getProjectDTO(), new AsyncCallback<String>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO - should add something here to allow for better error handling 
							RootLayoutPanel.get().add(new HTML("Error storing project."));
						}

						@Override
						public void onSuccess(String result) {
							viewProjectPresenter.go(event.getProjectDTO());
						}
						
					});
					
				}
				
			}
			
		}); 
	    
	}
	
}
