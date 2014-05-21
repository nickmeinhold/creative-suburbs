package com.creativesuburbs.prototype.client.view;

import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ViewStoredProjectsView extends Composite {

	private static ViewStoredProjectsViewUiBinder uiBinder = GWT.create(ViewStoredProjectsViewUiBinder.class);
	
	@UiField FlowPanel mainFlowPanel;

	interface ViewStoredProjectsViewUiBinder extends
			UiBinder<Widget, ViewStoredProjectsView> {
	}

	public ViewStoredProjectsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void addProject(ProjectDTO dto, HandlerManager eventBus) {
		
		mainFlowPanel.add(new ProjectCardView(dto, eventBus).asWidget());
		
	}
	
	public void clear() {
		mainFlowPanel.clear(); 
	}

}
