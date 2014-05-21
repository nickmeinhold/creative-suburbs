package com.creativesuburbs.prototype.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;

import com.creativesuburbs.prototype.client.CreativeSuburbsService;
import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CreativeSuburbsServiceImpl extends RemoteServiceServlet implements CreativeSuburbsService {

	@Override
	public String storeProject(ProjectDTO dto) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		ProjectDAO dao = new ProjectDAO(dto); 
		
		try {
	        
			pm.makePersistent(dao); 
			
	    } catch(Exception e) {
	    	
	    }
		finally {
	        pm.close();
	        
	    }
		
		return dao.getId(); 
		
	}

	@Override
	public List<ProjectDTO> retrieveAllProjects() {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Extent<ProjectDAO> extent = pm.getExtent(ProjectDAO.class, false);

		List<ProjectDTO> projects = new ArrayList<ProjectDTO>();
		for(ProjectDAO dao : extent) {
			projects.add(dao.toDTO());
		}

		extent.closeAll();
		pm.close();

		return projects;
		
	}

}
