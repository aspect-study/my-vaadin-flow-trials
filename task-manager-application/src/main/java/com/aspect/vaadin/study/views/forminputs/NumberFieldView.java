package com.aspect.vaadin.study.views.forminputs;

import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

@Route(value = "number-field-view", layout = MainLayout.class)
public class NumberFieldView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Number Field";
    }

    @Override
    protected String getDescription() {
        return """
                 Number Field is an input field that accepts only numeric input. The input can be a decimal or an integer.
                 There is also a big decimal for Flow.
                """;
    }

    @Override
    protected Component createComponent() {
        NumberField numberField = new NumberField();
        numberField.setValue(100.0);
        numberField.setLabel("Balance");
        numberField.setClearButtonVisible(true);
        //numberField.setPrefixComponent(VaadinIcon.DOLLAR.create());
        numberField.setSuffixComponent(VaadinIcon.EURO.create());
        return numberField;
    }

    @Override
    protected String getSourceCode() {
        return """
                NumberField numberField = new NumberField();
                numberField.setValue(100.0);
                numberField.setLabel("Balance");
                numberField.setClearButtonVisible(true);
                //numberField.setPrefixComponent(VaadinIcon.DOLLAR.create());
                numberField.setSuffixComponent(VaadinIcon.EURO.create());
                add(numberField);
                """;
    }
}
