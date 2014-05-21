package com.creativesuburbs.prototype.client;

import java.util.List;

import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreativeSuburbsServiceAsync {
	
	void storeProject(ProjectDTO dto, AsyncCallback<String> callback);

	void retrieveAllProjects(AsyncCallback<List<ProjectDTO>> callback); 

}
