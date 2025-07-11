package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;

@Route(value = "email-field-view", layout = MainLayout.class)
public class EmailFieldView extends VerticalLayout {

    public EmailFieldView() {

        H1 title = new H1("Email Field");

        Paragraph description = new Paragraph("""
                Email Field is an extension of Text Field that accepts only email addresses as input.
                If the given address is invalid, the field is highlighted in red and an error message appears underneath the input.
                """);
        add(title, description);

        EmailField emailField = new EmailField();
        emailField.setLabel("Email");
        emailField.setWidth("300px");
        emailField.setClearButtonVisible(true);
        emailField.setRequiredIndicatorVisible(true);
        emailField.setPlaceholder("Enter your email");
        emailField.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        emailField.setErrorMessage("Please enter a valid email address");
        add(emailField);

        Accordion show = new Accordion();
        show.add("source code",createCodeBlock());
        add(show);
    }

    private VerticalLayout createCodeBlock() {
        Span code = new Span("""
                EmailField emailField = new EmailField();
                emailField.setLabel("Email");
                emailField.setWidth("300px");
                emailField.setClearButtonVisible(true);
                emailField.setRequiredIndicatorVisible(true);
                emailField.setPlaceholder("Enter you email");
                emailField.setPrefixComponent(VaadinIcon.ENVELOPE.create());
                emailField.setErrorMessage("Please enter a valid email address");
                add(emailField);
                """);

        code.getElement().getStyle()
                .set("white-space", "pre-wrap")
                .set("font-family", "monospace")
                .set("padding", "1em")
                .set("border-radius", "8px")
                .set("border", "1px solid #ddd")
                .set("display", "block");

        VerticalLayout layout = new VerticalLayout(code);
        layout.setPadding(false);
        layout.setSpacing(false);
        return layout;
    }
}
