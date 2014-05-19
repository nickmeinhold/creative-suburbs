package com.creativesuburbs.prototype.client.presenter;

import com.creativesuburbs.prototype.client.events.NavigationRequestEvent;
import com.creativesuburbs.prototype.client.view.LandingPageView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class LandingPagePresenter {

	private HasWidgets container; 
	private LandingPageView view; 
	private HandlerManager eventBus; 
	
	public LandingPagePresenter(HasWidgets container, final HandlerManager eventBus) {
		
		this.container = container; 
		this.eventBus = eventBus; 
		this.view = new LandingPageView(); 
		
		// wire up event handler - this may be abstracted with an interface for Presenter and View at some point 
		view.getMakeStuffHappenButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new NavigationRequestEvent("PostProject")); 
			}
			
		}); 
		
	}
	
	public void go() {
		container.clear();
		container.add(view.asWidget()); 
	}
	
	
}
