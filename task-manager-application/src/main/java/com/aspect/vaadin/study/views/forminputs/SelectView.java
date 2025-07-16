package com.aspect.vaadin.study.views.forminputs;

import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;

@Route(value = "select-view", layout = MainLayout.class)
public class SelectView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Select";
    }

    @Override
    protected String getDescription() {
        return "Select allows users to choose a single value from a list of options presented in an overlay.";
    }

    @Override
    protected Component createComponent() {
        VerticalLayout displaySelectComponent = new VerticalLayout();

        Select<String> select = new Select<>();
        select.setLabel("Sort by");
        select.setItems("Most recent first", "Rating: high to low",
                "Rating: low to high", "Price: high to low",
                "Price: low to high");
        select.setValue("Most recent first");

        Select<String> selectWithDivider = new Select<>();
        selectWithDivider.setLabel("Sort by");
        selectWithDivider.setItems("Most recent first", "Rating: high to low",
                "Rating: low to high", "Price: high to low",
                "Price: low to high");
        selectWithDivider.addComponents("Most recent first", new Hr());
        selectWithDivider.addComponents("Rating: low to high", new Hr());
        selectWithDivider.setValue("Rating: low to high");

        displaySelectComponent.add(select, selectWithDivider);
        return displaySelectComponent;
    }

    @Override
    protected String getSourceCode() {
        return """
                VerticalLayout displaySelectComponent = new VerticalLayout();
                
                Select<String> select = new Select<>();
                select.setLabel("Sort by");
                select.setItems("Most recent first", "Rating: high to low",
                        "Rating: low to high", "Price: high to low",
                        "Price: low to high");
                select.setValue("Most recent first");
                
                Select<String> selectWithDivider = new Select<>();
                selectWithDivider.setLabel("Sort by");
                selectWithDivider.setItems("Most recent first", "Rating: high to low",
                        "Rating: low to high", "Price: high to low",
                        "Price: low to high");
                selectWithDivider.addComponents("Most recent first", new Hr());
                selectWithDivider.addComponents("Rating: low to high", new Hr());
                selectWithDivider.setValue("Most recent first");
                displaySelectComponent.add(select, selectWithDivider);
                """;
    }
}
