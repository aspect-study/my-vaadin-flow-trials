package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

@Route(value = "number-field-view", layout = MainLayout.class)
public class NumberFieldView extends VerticalLayout {

    public NumberFieldView() {
        H1 title = new H1("Number Field");
        String desc = """
                Number Field is an input field that accepts only numeric input. The input can be a decimal or an integer.
                There is also a big decimal for Flow.
                """;
        Paragraph description = new Paragraph(desc);
        add(title, description);

        NumberField numberField = new NumberField();
        numberField.setValue(100.0);
        numberField.setLabel("Balance");
        numberField.setClearButtonVisible(true);
        //numberField.setPrefixComponent(VaadinIcon.DOLLAR.create());
        numberField.setSuffixComponent(VaadinIcon.EURO.create());
        add(numberField);

        Accordion show = new Accordion();
        show.add("source code",createCodeBlock());
        add(show);
    }

    private VerticalLayout createCodeBlock() {
        Span code = new Span("""
                NumberField numberField = new NumberField();
                numberField.setValue(100.0);
                numberField.setLabel("Balance");
                numberField.setClearButtonVisible(true);
                //numberField.setPrefixComponent(VaadinIcon.DOLLAR.create());
                numberField.setSuffixComponent(VaadinIcon.EURO.create());
                add(numberField);
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
