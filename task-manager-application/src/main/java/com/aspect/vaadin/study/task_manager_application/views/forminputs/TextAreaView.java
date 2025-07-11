package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
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
public class TextAreaView extends VerticalLayout {

    public TextAreaView() {
        H1 title = new H1("Text Area");
        String desc = """
                Text Area is an input field component that allows entry of multiple lines of text.
                """;
        Paragraph description = new Paragraph(desc);
        add(title, description);

        TextArea textArea = new TextArea();
        textArea.setWidthFull();
        textArea.setLabel("Comment");
        textArea.setClearButtonVisible(true);
        textArea.setValue("Great Job!");
        add(textArea);

        Accordion show = new Accordion();
        show.add("source code",createCodeBlock());
        add(show);
    }

    private VerticalLayout createCodeBlock() {
        Span code = new Span("""
                TextArea textArea = new TextArea();
                textArea.setWidthFull();
                textArea.setLabel("Comment");
                textArea.setClearButtonVisible(true);
                textArea.setValue("Great Job!");
                add(textArea);
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
