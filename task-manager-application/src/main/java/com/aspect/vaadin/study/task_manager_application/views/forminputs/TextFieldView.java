package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "text-field-view", layout = MainLayout.class)
public class TextFieldView extends VerticalLayout {

    public TextFieldView() {

        H1 title = new H1("Text Field");
        Paragraph description = new Paragraph("Text Field allows users to enter text. Prefix and suffix components, such as icons, are also supported.");
        add(title, description);

        TextField name = new TextField();
        name.setLabel("Your Name");
        name.setPlaceholder("Name");
        name.setClearButtonVisible(true);
        name.setPrefixComponent(VaadinIcon.USER.create());
        add(name);

        Accordion show = new Accordion();
        show.add("source code",createCodeBlock());
        add(show);
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
