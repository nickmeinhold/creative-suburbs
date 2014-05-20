package com.creativesuburbs.prototype.client.presenter;

import com.creativesuburbs.prototype.client.events.NavigationRequestEvent;
import com.creativesuburbs.prototype.client.view.PostProjectDialog;
import com.creativesuburbs.prototype.client.view.PostProjectView;
import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class PostProjectPresenter {
	
	private PostProjectView view; 
	private HasWidgets container; 
	private HandlerManager eventBus; 
	
	private PostProjectDialog postProjectDialog;
	private ProjectDTO newProject; 
	
	public PostProjectPresenter(HasWidgets container, final HandlerManager eventBus)
	{
		this.container = container; 
		this.eventBus = eventBus; 
		
		// this order needs to be maintained because of weirdness of suggestbox 
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		oracle.add("Melbourne");
		oracle.add("St Kilda");
		oracle.add("Carlton");
		oracle.add("Brunswick");
		
		this.view = new PostProjectView(oracle); 
		
		fillVerbsList(view.getVerbListBox());
		
		view.getPostButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				postProjectDialog = new PostProjectDialog(); 
				
				postProjectDialog.getContinueButton().addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						postProjectDialog.fillProjectDTO(newProject); 
						postProjectDialog.hide(); 
						fillProjectDTO(); 
						eventBus.fireEvent(new NavigationRequestEvent("ViewProject", newProject)); 
					}
					
				}); 
				
				postProjectDialog.show();
			}
			
		});
		
	}
	
	public void go() {
		container.clear();
		container.add(view.asWidget()); 
		
		// should the declaration be elsewhere? 
		newProject = new ProjectDTO(); 
		
	}
	
	private void fillVerbsList(ListBox verbList) {
		
		verbList.addItem("build", "1"); 
		verbList.addItem("start", "2"); 
		verbList.addItem("get", "3"); 
	}
	
	private void fillProjectDTO()
	{
		this.newProject.setProjectName(view.getProjectNameTextBox().getText()); 
		// TODO - add the rest 
	}
	
}
