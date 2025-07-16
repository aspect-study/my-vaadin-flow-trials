package com.aspect.vaadin.study.views.forminputs;

import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.Route;

@Route(value = "radio-button-view", layout = MainLayout.class)
public class RadioButtonGroupView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Radio Button";
    }

    @Override
    protected String getDescription() {
        return """
                Radio Button Group allows users to select one value among multiple choices.
                
                Read-Only
                Use read-only when content needs to be accessible but not editable.
                Read-only elements can’t be edited, but they’re part of the tabbing order and can thus receive focus.
                The content of a read-only input can be selected and copied.
                """;
    }

    @Override
    protected Component createComponent() {
        VerticalLayout displayRadioButtons = new VerticalLayout();

        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        radioGroup.setLabel("Travel class");
        radioGroup.setItems("Economy", "Business", "First Class");

        RadioButtonGroup<String> radioGroupReadOnly = new RadioButtonGroup<>();
        radioGroupReadOnly.setLabel("Status");
        radioGroupReadOnly.setItems("In progress", "Done", "Cancelled");
        radioGroupReadOnly.setValue("In progress");
        radioGroupReadOnly.setReadOnly(true);

        displayRadioButtons.add(radioGroup, radioGroupReadOnly);

        return displayRadioButtons;
    }

    @Override
    protected String getSourceCode() {
        return """
                VerticalLayout displayRadioButtons = new VerticalLayout();
                
                RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
                radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
                radioGroup.setLabel("Travel class");
                radioGroup.setItems("Economy", "Business", "First Class");
                
                RadioButtonGroup<String> radioGroupReadOnly = new RadioButtonGroup<>();
                radioGroupReadOnly.setLabel("Status");
                radioGroupReadOnly.setItems("In progress", "Done", "Cancelled");
                radioGroupReadOnly.setValue("In progress");
                radioGroupReadOnly.setReadOnly(true);
                
                displayRadioButtons.add(radioGroup, radioGroupReadOnly);
                """;
    }
}
