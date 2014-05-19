package com.creativesuburbs.prototype.client;

import com.creativesuburbs.prototype.client.events.NavigationRequestEvent;
import com.creativesuburbs.prototype.client.events.NavigationRequestEventHandler;
import com.creativesuburbs.prototype.client.presenter.LandingPagePresenter;
import com.creativesuburbs.prototype.client.presenter.PostProjectPresenter;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class AppController {

	private HandlerManager eventBus;
	private LandingPagePresenter landingPagePresenter;
	private PostProjectPresenter postProjectPresenter;
	
	public AppController(GreetingServiceAsync greetingService, HandlerManager eventBus)
	{
		this.eventBus = eventBus; 
		
		landingPagePresenter = new LandingPagePresenter(RootLayoutPanel.get(), eventBus); 
		postProjectPresenter = new PostProjectPresenter(RootLayoutPanel.get(), eventBus); 
		
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
			public void onMessageReceived(NavigationRequestEvent event) {
				
				if(event.getToPage().equals("PostProject")) 
				{
					postProjectPresenter.go();
				}
				
			}
			
		}); 
	    
	}
	
}
