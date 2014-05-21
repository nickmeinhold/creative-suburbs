package com.creativesuburbs.prototype.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class LandingPageView extends Composite {

	private static LandingPageViewUiBinder uiBinder = GWT.create(LandingPageViewUiBinder.class);

	@UiField Button makeStuffHappenBtn; 
	@UiField Button rBtn; 
	
	interface LandingPageViewUiBinder extends UiBinder<Widget, LandingPageView> {
	}

	public LandingPageView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public Button getMakeStuffHappenButton() 
	{
		return makeStuffHappenBtn; 
	}
	
	public Button getRButton() 
	{
		return rBtn; 
	}

}
