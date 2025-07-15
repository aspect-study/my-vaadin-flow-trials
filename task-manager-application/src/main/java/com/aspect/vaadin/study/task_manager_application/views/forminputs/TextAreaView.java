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
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route(value = "text-area-view", layout = MainLayout.class)
public class TextAreaView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Text Area";
    }

    @Override
    protected String getDescription() {
        return """
                Text Area is an input field component that allows entry of multiple lines of text.
                """;
    }

    @Override
    protected Component createComponent() {
        TextArea textArea = new TextArea();
        textArea.setWidthFull();
        textArea.setLabel("Comment");
        textArea.setClearButtonVisible(true);
        textArea.setValue("Great Job!");
        return textArea;
    }

    @Override
    protected String getSourceCode() {
        return """
                TextArea textArea = new TextArea();
                textArea.setWidthFull();
                textArea.setLabel("Comment");
                textArea.setClearButtonVisible(true);
                textArea.setValue("Great Job!");
                add(textArea);
                """;
    }
}
