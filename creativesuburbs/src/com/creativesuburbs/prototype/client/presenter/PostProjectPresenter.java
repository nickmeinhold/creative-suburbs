package com.creativesuburbs.prototype.client.presenter;

import com.creativesuburbs.prototype.client.view.PostProjectView;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class PostProjectPresenter {
	
	private PostProjectView view; 
	private HasWidgets container; 
	private HandlerManager eventBus; 
	
	public PostProjectPresenter(HasWidgets container, final HandlerManager eventBus)
	{
		this.container = container; 
		this.eventBus = eventBus; 
		
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		oracle.add("Melbourne");
		oracle.add("St Kilda");
		oracle.add("Carlton");
		oracle.add("Brunswick");
		
		this.view = new PostProjectView(oracle); 
		
		fillVerbsList(view.getVerbListBox());
		
	}
	
	public void go() {
		container.clear();
		container.add(view.asWidget()); 
	}
	
	private void fillVerbsList(ListBox verbList) {
		
		verbList.addItem("build", "1"); 
		verbList.addItem("start", "1"); 
		verbList.addItem("get", "1"); 
	}
	
	
}
