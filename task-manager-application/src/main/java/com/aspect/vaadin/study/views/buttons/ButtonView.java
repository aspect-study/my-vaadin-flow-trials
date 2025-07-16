package com.aspect.vaadin.study.views.buttons;

import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "button-view", layout = MainLayout.class)
public class ButtonView extends VerticalLayout {

    public ButtonView() {

        // Set some basic properties for the layout itself
        setSizeFull(); // Make the layout take up the full available space
        setAlignItems(Alignment.CENTER); // Center content horizontally
        setJustifyContentMode(JustifyContentMode.CENTER); // Center content vertically
        setSpacing(true); // Add space between components
        setPadding(true); // Add padding around the layout

        H1 title = new H1("Welcome to Buttons Vertical Layout!");
        Paragraph description = new Paragraph("This is an example of components arranged vertically.");
        add(title, description);
        // Create some components to add to the layout
        buttonView();
    }

    public void buttonView() {
        // 1. Basic Button with Text
        Button simpleButton = new Button("Click Me!");
        simpleButton.addClickListener(event -> {
            Notification.show("Simple button clicked!", 3000, Notification.Position.MIDDLE);
            simpleButton.setText("Clicked!"); // Change button text after click
        });
        add(new Paragraph("1. Basic Button:"), simpleButton);

        // 2. Button with Icon
        // You can use VaadinIcon enum for built-in icons
        Button iconButton = new Button("Save", VaadinIcon.CHECK.create());
        iconButton.addClickListener(event -> Notification.show("Save button clicked!", 3000, Notification.Position.TOP_END));
        add(new Paragraph("2. Button with Icon:"), iconButton);

        // 3. Icon Only Button
        Button onlyIconButton = new Button(VaadinIcon.TRASH.create());
        onlyIconButton.addClickListener(event -> Notification.show("Trash button clicked!", 3000, Notification.Position.TOP_END));
        add(new Paragraph("3. Icon Only Button:"), onlyIconButton);

        // 4. Button with Theme Variants
        // Theme variants change the visual style
        Button primaryButton = new Button("Primary Action");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        primaryButton.addClickListener(event -> Notification.show("Primary button clicked!"));

        Button successButton = new Button("Success Action");
        successButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        successButton.addClickListener(event -> Notification.show("Success button clicked!"));

        Button errorButton = new Button("Delete Item", VaadinIcon.WARNING.create());
        errorButton.addThemeVariants(ButtonVariant.LUMO_ERROR,
                ButtonVariant.LUMO_PRIMARY); // Can combine
        errorButton.addClickListener(event -> Notification.show("Error button clicked!"));

        Div variantButtons = new Div(primaryButton, successButton, errorButton);
        //variantButtons.getStyle().set("display", "flex").set("gap", "5px");
        variantButtons.addClassName("variant-buttons");// Basic flexbox for horizontal arrangement
        add(new Paragraph("4. Buttons with Theme Variants:"), variantButtons);

        // 5. Disabled Button
        Button disabledButton = new Button("Disabled Button");
        disabledButton.setEnabled(false); // Set button to disabled state
        disabledButton.addClickListener(event -> Notification.show("You won't see this!")); // This won't fire
        add(new Paragraph("5. Disabled Button:"), disabledButton);

        Button backToMainButton = new Button("Back to Main Menu!");
        backToMainButton.addClickListener(e -> UI.getCurrent().navigate(""));
        add(backToMainButton);
    }
}
