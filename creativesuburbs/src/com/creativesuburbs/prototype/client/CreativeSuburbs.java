package com.creativesuburbs.prototype.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;

public class CreativeSuburbs implements EntryPoint {
	
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public void onModuleLoad() {
		
	    HandlerManager eventBus = new HandlerManager(null);
	    AppController appController = new AppController(greetingService, eventBus); 
	    appController.go();
		
		
	}
}
