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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "text-field-view", layout = MainLayout.class)
public class TextFieldView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Text Field";
    }

    @Override
    protected String getDescription() {
        return "Text Field allows users to enter text. Prefix and suffix components, such as icons, are also supported.";
    }

    @Override
    protected Component createComponent() {
        TextField name = new TextField();
        name.setLabel("Your Name");
        name.setPlaceholder("Name");
        name.setClearButtonVisible(true);
        name.setPrefixComponent(VaadinIcon.USER.create());
        return name;
    }

    @Override
    protected String getSourceCode() {
        return """
                TextField textField = new TextField();
                textField.setLabel("Your Name);
                textField.setPlaceholder("Name");
                textField.setClearButtonVisible(true);
                textField.setPrefixComponent(VaadinIcon.USER.create());
                add(textField);
                """;
    }
}
