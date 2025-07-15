package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.router.Route;

@Route(value = "bigdecimal-field-view", layout = MainLayout.class)
public class BigDecimalFieldView extends ComponentView {

    @Override
    protected String getTitle() {
        return "BigDecimal Field";
    }

    @Override
    protected String getDescription() {
        return """
                BigDecimalField is an input field for handling decimal numbers with high precision. This field uses BigDecimal   as the server-side value type, and only allows numeric input.
                When setting values from the server-side, the scale of the provided BigDecimal   is preserved in the presentation format shown to the user, as described in setValue(BigDecimal).
                """;
    }

    @Override
    protected Component createComponent() {
        BigDecimalField bigDecimalField = new BigDecimalField();
        bigDecimalField.setLabel("Amount");
        return bigDecimalField;
    }

    @Override
    protected String getSourceCode() {
        return """
                BigDecimalField bigDecimalField = new BigDecimalField();
                bigDecimalField.setLabel("Amount");
                """;
    }
}
