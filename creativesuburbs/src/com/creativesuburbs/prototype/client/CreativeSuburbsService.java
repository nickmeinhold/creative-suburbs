package com.creativesuburbs.prototype.client;

import java.util.List;

import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("creativesuburbs")
public interface CreativeSuburbsService extends RemoteService {
	String storeProject(ProjectDTO dto); 
	List<ProjectDTO> retrieveAllProjects(); 
}
