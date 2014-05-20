package com.creativesuburbs.prototype.client.events;

import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.event.shared.GwtEvent;

public class NavigationRequestEvent extends GwtEvent<NavigationRequestEventHandler> 
{
	
	public static Type<NavigationRequestEventHandler> TYPE = new Type<NavigationRequestEventHandler>(); 
	private String toPage; 
	private ProjectDTO projectDTO; 
	
	public NavigationRequestEvent(String toPage)
	{
		this.toPage = toPage; 
	}
	
	public NavigationRequestEvent(String toPage, ProjectDTO projectDTO)
	{
		this.toPage = toPage; 
		this.projectDTO = projectDTO; 
	}
	
	@Override
	public Type<NavigationRequestEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(NavigationRequestEventHandler handler) {
		handler.onMessageReceived(this);
	}
	
	public String getToPage() 
	{
		return toPage; 
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}
	
	

}
