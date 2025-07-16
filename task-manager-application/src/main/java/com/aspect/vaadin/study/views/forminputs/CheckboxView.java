package com.aspect.vaadin.study.views.forminputs;

import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.router.Route;

@Route(value = "checkbox-view", layout = MainLayout.class)
public class CheckboxView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Check Box";
    }

    @Override
    protected String getDescription() {
        return "Checkbox is an input field representing a binary choice. Checkbox Group is a group of related binary choices.";
    }

    @Override
    protected Component createComponent() {
        Checkbox checkbox = new Checkbox();
        checkbox.setLabel("I accept the terms and conditions");
        checkbox.setValue(true);
        checkbox.setRequiredIndicatorVisible(true);
        checkbox.setTooltipText("Required");
        return checkbox;
    }

    @Override
    protected String getSourceCode() {
        return """
                Checkbox checkbox = new Checkbox();
                checkbox.setLabel("I accept the terms and conditions");
                checkbox.setValue(true);
                checkbox.setRequiredIndicatorVisible(true);
                checkbox.setTooltipText("Required");
                """;
    }
}
