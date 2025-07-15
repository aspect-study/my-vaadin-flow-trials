package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.router.Route;

@Route(value = "checkbox-group-view", layout = MainLayout.class)
public class GroupCheckboxView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Checkbox Group";
    }

    @Override
    protected String getDescription() {
        return """
                Use Checkbox Group to group related items.
                Individual checkboxes should be used for options that aren’t necessarily related to each other in any way.
                """;
    }

    @Override
    protected Component createComponent() {
        CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
        checkboxGroup.setLabel("Export data");
        checkboxGroup.setItems("Order ID", "Product name", "Customer","Status");
        checkboxGroup.select("Order ID", "Customer");
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        return checkboxGroup;
    }

    @Override
    protected String getSourceCode() {
        return """
                CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
                checkboxGroup.setLabel("Export data");
                checkboxGroup.setItems("Order ID", "Product name", "Customer","Status");
                checkboxGroup.select("Order ID", "Customer");
                checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
                """;
    }
}
