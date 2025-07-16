package com.aspect.vaadin.study.views.common.ui.util.abstractcomponent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.checkerframework.checker.units.qual.C;

public abstract class ComponentView extends VerticalLayout {

    protected abstract String getTitle();
    protected abstract String getDescription();
    protected abstract Component createComponent();
    protected abstract String getSourceCode();

    public ComponentView() {
        add(createTitle());
        add(createDescription());
        add(createComponent());
        add(createSourceCodeAccordion());
    }

    protected Component createTitle() {
        return new H1(getTitle());
    }

    protected Component createDescription() {
        return new Paragraph(getDescription());
    }

    protected Component createSourceCodeAccordion() {
        Accordion show = new Accordion();
        show.add("source code",createCodeBlock(getSourceCode()));
        return show;
    }

    private VerticalLayout createCodeBlock(String codeBlock) {
        Span code = new Span(codeBlock);

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
