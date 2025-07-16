package com.aspect.vaadin.study.views.layouts;

import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "horizontal-view", layout = MainLayout.class)
public class HorizontalLayoutView extends VerticalLayout {

    public HorizontalLayoutView() {

        // Set some basic properties for the layout itself
        setSizeFull(); // Make the layout take up the full available space
        setAlignItems(Alignment.CENTER); // Center content horizontally
        setJustifyContentMode(JustifyContentMode.CENTER); // Center content vertically
        setSpacing(true); // Add space between components
        setPadding(true); // Add padding around the layout

        // Create some components to add to the layout
        horizontalLayoutView();
    }

    public void horizontalLayoutView() {

        HorizontalLayout titleHorizontalLayout = new HorizontalLayout();
        // Create some components to add to the layout
        H1 title = new H1("Welcome to Vertical Layout with Horizontal Layout!");

        String info = "This is an example of components arranged vertically and horizontally.";
        Paragraph description = new Paragraph();
        description.setText(info);
        titleHorizontalLayout.add(title, description);
        add(titleHorizontalLayout);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        // Set some basic properties for the layout itself
        horizontalLayout.setWidth("80%"); // Make the layout take up 80% of the available width
        horizontalLayout.setHeight("100px"); // Give it a fixed height for demonstration
        horizontalLayout.setJustifyContentMode(JustifyContentMode.START); // Center content horizontally within the layout
        horizontalLayout.setVerticalComponentAlignment(Alignment.CENTER); // Center content vertically within the layout
        horizontalLayout.setSpacing(true); // Add space between components
        horizontalLayout.setPadding(true); // Add padding around the layout

        // Add a border for better visualization (optional, for demo purposes)
        horizontalLayout.getStyle().set("border", "1px solid light gray");

        // Create some components to add to the layout
        TextField searchField = new TextField();
        searchField.setPlaceholder("Search...");
        searchField.setWidth("200px"); // Give the text field a fixed width
        // Demonstrate flex grow: Make searchField take up remaining space
        horizontalLayout.setFlexGrow(1, searchField); // Uncomment to see how searchField expands

        Button searchButton = new Button("Search");
        Button addButton = new Button("Add New");

        Span infoText = new Span("Items found: 15");

        // Add components to the HorizontalLayout
        horizontalLayout.add(searchField, searchButton, addButton, infoText);

        // You can also individually set alignment for specific components (overrides default)
        horizontalLayout.setVerticalComponentAlignment(
                Alignment.END, infoText); // Align infoText to the bottom

        // Add a listener to a button (optional for layout example)
        searchButton.addClickListener(e -> {
            System.out.println("Searching for: " + searchField.getValue());
            infoText.setText("Searching...");
        });

        add(horizontalLayout);

        Button backToMainButton = new Button("Back to Main Menu!");
        backToMainButton.addClickListener(e -> {
            UI.getCurrent().navigate("");
        });
        add(backToMainButton);
    }
}
