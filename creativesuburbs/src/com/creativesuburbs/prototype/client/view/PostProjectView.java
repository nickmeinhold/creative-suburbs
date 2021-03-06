package com.creativesuburbs.prototype.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Button;

public class PostProjectView extends Composite {

	private static PostProjectViewUiBinder uiBinder = GWT.create(PostProjectViewUiBinder.class);
	
	@UiField ListBox verbListBox; 
	@UiField TextBox projectNameTextBox; 
	@UiField(provided = true) SuggestBox locationSuggestBox;
	@UiField Button postButton;

	interface PostProjectViewUiBinder extends UiBinder<Widget, PostProjectView> {
	}

	public PostProjectView(MultiWordSuggestOracle oracle) {
		
		// the suggestbox apparently needs to be created before the initWidget call 
		locationSuggestBox = new SuggestBox(oracle);
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	public ListBox getVerbListBox()
	{
		return verbListBox; 
	}
	
	public TextBox getProjectNameTextBox()
	{
		return projectNameTextBox; 
	}
	
	public SuggestBox getLocationSuggestBox()
	{
		return this.locationSuggestBox; 
	}
	
	public Button getPostButton() 
	{
		return this.postButton; 
	}
	
	public ValueBoxBase<String> getProjectLocationTextBox() 
	{
		return this.locationSuggestBox.getValueBox(); 
	}
	
	public String getProjectVerb()
	{
		return this.verbListBox.getItemText(this.verbListBox.getSelectedIndex()); 
	}
	
}
