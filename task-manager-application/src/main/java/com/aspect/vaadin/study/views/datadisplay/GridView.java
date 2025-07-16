package com.aspect.vaadin.study.views.datadisplay;

import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Inline;
import com.vaadin.flow.router.Route;

@Route(value = "grid-view", layout = MainLayout.class)
public class GridView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Grid Component";
    }

    @Override
    protected String getDescription() {
        return "Vaadin Grid is a component for displaying tabular data, including various enhancements to grid renderings.";
    }

    @Override
    protected Component createComponent() {

        Paragraph paragraph = new Paragraph();
        paragraph.setText("Some of the more complex features of this component are described on separate tabs:");
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(paragraph);
        return verticalLayout;
    }

    @Override
    protected String getSourceCode() {
        return "";
    }
}
