package com.creativesuburbs.prototype.client.view;

import com.creativesuburbs.prototype.shared.ProjectDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RadioButton;

public class PostProjectDialog extends DialogBox {

	private static PostProjectDialogUiBinder uiBinder = GWT.create(PostProjectDialogUiBinder.class);
	@UiField VerticalPanel teamSubList;
	@UiField CheckBox teamHelpCB;
	@UiField TextBox addImageTB;
	@UiField Button addImageButton;
	@UiField Image image;
	@UiField Button continueButton;
	@UiField RadioButton streetSizeRB;
	@UiField RadioButton neighbourhoodSizeRB;
	@UiField RadioButton citySizeRB;
	@UiField CheckBox financeHelpCB;
	@UiField CheckBox govHelpCB;

	interface PostProjectDialogUiBinder extends UiBinder<Widget, PostProjectDialog> {
	}

	public PostProjectDialog() {
		setWidget(uiBinder.createAndBindUi(this)); 
		
		teamSubList.setVisible(false); 
		teamHelpCB.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if(event.getValue())
				{
					teamSubList.setVisible(true); 
				}
				else 
				{
					teamSubList.setVisible(false); 
				}
			}
			
		}); 
		
		addImageButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				image.setUrl(addImageTB.getText());
			}
			
		});
		
		//setAutoHideEnabled(true);
        setText("Add More Details...");
        setGlassEnabled(true);
        center();
	}
	
	public Button getAddImageButton() 
	{
		return this.addImageButton; 
	}
	
	public void fillProjectDTO(ProjectDTO dto) 
	{
		dto.setFinanceHelp(this.financeHelpCB.getValue());
		dto.setGovHelp(this.govHelpCB.getValue());
		if(this.teamHelpCB.getValue()) {
			if(this.streetSizeRB.getValue()) dto.setTeamSize(1);
			else if(this.neighbourhoodSizeRB.getValue()) dto.setTeamSize(2);
			else if(this.citySizeRB.getValue()) dto.setTeamSize(3);
			else dto.setTeamSize(0); 
		}
		dto.setImageUrl(this.addImageTB.getText());
	}
	
	public Button getContinueButton()
	{
		return this.continueButton; 
	}

}
