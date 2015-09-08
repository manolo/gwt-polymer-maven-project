package com.example.myapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.paper.widget.PaperButton;
import com.vaadin.polymer.paper.widget.PaperInput;
import com.vaadin.polymer.paper.widget.PaperToast;

public class MyApp implements EntryPoint {

	public void onModuleLoad() {
	    Polymer.importHref("iron-icon");
        Polymer.importHref("iron-icons");

        PaperButton button = new PaperButton("Click-Me");
        final PaperInput input = new PaperInput("Name");
        final PaperToast toast = new PaperToast();
        
        RootPanel.get().add(button);
        RootPanel.get().add(input);
        RootPanel.get().add(toast);

        input.setPattern("[A-Z]*");
        input.setAutoValidate(true);
        input.setErrorMessage("Onpy upercased letters are allowed");
        
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                toast.setText("Sending your message: " + input.getValue());
                toast.show();
            }
        });
        
	}
}
