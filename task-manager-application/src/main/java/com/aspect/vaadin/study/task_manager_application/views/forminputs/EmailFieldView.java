package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;

@Route(value = "email-field-view", layout = MainLayout.class)
public class EmailFieldView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Email Field";
    }

    @Override
    protected String getDescription() {
        return """
                 Email Field is an extension of Text Field that accepts only email addresses as input.
                 If the given address is invalid, the field is highlighted in red and an error message appears underneath the input.
                """;
    }

    @Override
    protected Component createComponent() {
        EmailField emailField = new EmailField();
        emailField.setLabel("Email");
        emailField.setWidth("300px");
        emailField.setClearButtonVisible(true);
        emailField.setRequiredIndicatorVisible(true);
        emailField.setPlaceholder("Enter your email");
        emailField.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        emailField.setErrorMessage("Please enter a valid email address");
        return emailField;
    }

    @Override
    protected String getSourceCode() {
        return """
                 EmailField emailField = new EmailField();
                 emailField.setLabel("Email");
                 emailField.setWidth("300px");
                 emailField.setClearButtonVisible(true);
                 emailField.setRequiredIndicatorVisible(true);
                 emailField.setPlaceholder("Enter you email");
                 emailField.setPrefixComponent(VaadinIcon.ENVELOPE.create());
                 emailField.setErrorMessage("Please enter a valid email address");
                 add(emailField);
                """;
    }
}
