package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route(value = "password-field-view", layout = MainLayout.class)
public class PasswordFieldView extends VerticalLayout {

    public PasswordFieldView() {
        H1 title = new H1("Password Field");
        String desc = """
                Password Field is an input field for entering passwords.
                The input is masked by default. On mobile devices, though,
                the last typed letter is shown for a brief moment.
                The masking can be toggled using an optional reveal button.
                """;
        Paragraph description = new Paragraph(desc);
        add(title, description);

        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setValue("aspect@test.com");
        passwordField.setPrefixComponent(VaadinIcon.PASSWORD.create());
        add(passwordField);

        Accordion show = new Accordion();
        show.add("source code",createCodeBlock());
        add(show);
    }

    private VerticalLayout createCodeBlock() {
        Span code = new Span("""
                PasswordField passwordField = new PasswordField();
                passwordField.setLabel("Password");
                passwordField.setValue("aspect@test.com");
                passwordField.setPrefixComponent(VaadinIcon.PASSWORD.create());
                add(passwordField);
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
