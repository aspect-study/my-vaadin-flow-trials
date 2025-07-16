package com.aspect.vaadin.study.views.forminputs;

import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "date-picker-view", layout = MainLayout.class)
public class DatePickerView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Date Picker";
    }

    @Override
    protected String getDescription() {
        return """
                Date Picker is an input field that allows the user to enter a date by typing or by selecting from a calendar overlay.
                
                Try clicking the calendar icon. A calendar overlay appears, showing the current month. Click on a date to select it.
                """;
    }

    @Override
    protected Component createComponent() {
        HorizontalLayout displayDatePicker = new HorizontalLayout();
        DatePicker startDate = new DatePicker("Start date");
        startDate.setRequired(true);

        DatePicker endDate = new DatePicker("End date");
        endDate.setRequired(true);

        displayDatePicker.add(startDate, endDate);
        return displayDatePicker;
    }

    @Override
    protected String getSourceCode() {
        return """
                HorizontalLayout displayDatePicker = new HorizontalLayout();
                DatePicker startDate = new DatePicker("Start date");
                startDate.setRequired(true);
                
                DatePicker endDate = new DatePicker("End date");
                endDate.setRequired(true);
                
                displayDatePicker.add(startDate, endDate);
                """;
    }
}
