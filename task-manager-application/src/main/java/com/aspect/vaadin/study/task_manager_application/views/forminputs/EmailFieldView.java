package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
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
        add(emailField);
//
//        Accordion show = new Accordion();
//        show.add("source code",createCodeBlock());
//        add(show);
    }

    private VerticalLayout createCodeBlock() {
        Span code = new Span("""
                TextField textField = new TextField();
                textField.setLabel("Your Name);
                textField.setPlaceholder("Name");
                textField.setClearButtonVisible(true);
                textField.setPrefixComponent(VaadinIcon.USER.create());
                add(textField);
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
