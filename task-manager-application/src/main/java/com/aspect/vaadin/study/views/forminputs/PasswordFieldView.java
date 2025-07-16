package com.aspect.vaadin.study.views.forminputs;

import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route(value = "password-field-view", layout = MainLayout.class)
public class PasswordFieldView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Password Field";
    }

    @Override
    protected String getDescription() {
        return """
                Password Field is an input field for entering passwords.
                The input is masked by default. On mobile devices, though,
                the last typed letter is shown for a brief moment.
                The masking can be toggled using an optional reveal button.
                """;
    }

    @Override
    protected Component createComponent() {
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setValue("aspect@test.com");
        passwordField.setPrefixComponent(VaadinIcon.PASSWORD.create());
        return passwordField;
    }

    @Override
    protected String getSourceCode() {
        return """
                PasswordField passwordField = new PasswordField();
                passwordField.setLabel("Password");
                passwordField.setValue("aspect@test.com");
                passwordField.setPrefixComponent(VaadinIcon.PASSWORD.create());
                add(passwordField);
                """;
    }
}
