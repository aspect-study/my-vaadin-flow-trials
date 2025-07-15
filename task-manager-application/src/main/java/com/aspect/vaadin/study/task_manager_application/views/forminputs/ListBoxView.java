package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.router.Route;

@Route(value = "list-box-view", layout = MainLayout.class)
public class ListBoxView extends ComponentView {

    @Override
    protected String getTitle() {
        return "List Box";
    }

    @Override
    protected String getDescription() {
        return "List Box allows the user to select one or more values from a scrollable list of items.";
    }

    @Override
    protected Component createComponent() {
        MultiSelectListBox<String> listBox = new MultiSelectListBox<>();
        listBox.setItems("SHOW_ASSIGNEE", "SHOW_DUE_DATE", "SHOW_STATUS");
        listBox.select("SHOW_ASSIGNEE", "SHOW_STATUS");
        return listBox;
    }

    @Override
    protected String getSourceCode() {
        return """
                MultiSelectListBox<String> listBox = new MultiSelectListBox<>();
                listBox.setItems("SHOW_ASSIGNEE", "SHOW_DUE_DATE", "SHOW_STATUS");
                listBox.select("SHOW_ASSIGNEE", "SHOW_STATUS")
                """;
    }
}
