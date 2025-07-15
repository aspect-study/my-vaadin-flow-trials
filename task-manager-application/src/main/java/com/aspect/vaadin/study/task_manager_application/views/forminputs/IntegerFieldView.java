package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;

@Route(value = "integer-field-view", layout = MainLayout.class)
public class IntegerFieldView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Integer Field";
    }

    @Override
    protected String getDescription() {
        return "IntegerField is an extension of Text Field that only accepts integer numbers.";
    }

    @Override
    protected Component createComponent() {
        IntegerField integerField = new IntegerField();
        integerField.setLabel("Age");
        return integerField;
    }

    @Override
    protected String getSourceCode() {
        return """
                IntegerField integerField = new IntegerField();
                integerField.setLabel("Age");
                """;
    }
}
