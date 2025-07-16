package com.aspect.vaadin.study.views.layouts;

import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "vertical-view", layout = MainLayout.class)
public class VerticalLayoutView extends VerticalLayout {

    public VerticalLayoutView() {

        // Set some basic properties for the layout itself
        setSizeFull(); // Make the layout take up the full available space
        setAlignItems(Alignment.CENTER); // Center content horizontally
        setJustifyContentMode(JustifyContentMode.CENTER); // Center content vertically
        setSpacing(true); // Add space between components
        setPadding(true); // Add padding around the layout

        // Create some components to add to the layout
        H1 title = new H1("Welcome to Vertical Layout!");
        Paragraph description = new Paragraph("This is an example of components arranged vertically.");
        Button clickMeButton = new Button("Click Me!");
        Button backToMainButton = new Button("Back to Main Menu!");
        backToMainButton.addClickListener(e -> {
            UI.getCurrent().navigate("");
        });
        // Add components to the VerticalLayout
        add(title, description, clickMeButton, backToMainButton);
    }
}
