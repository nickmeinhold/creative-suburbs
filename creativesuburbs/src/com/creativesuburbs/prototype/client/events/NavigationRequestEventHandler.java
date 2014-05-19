package com.creativesuburbs.prototype.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface NavigationRequestEventHandler extends EventHandler {

	void onMessageReceived(NavigationRequestEvent event);
	
}
