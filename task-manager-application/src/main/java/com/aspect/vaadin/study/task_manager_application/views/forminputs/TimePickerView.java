package com.aspect.vaadin.study.task_manager_application.views.forminputs;

import com.aspect.vaadin.study.task_manager_application.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.task_manager_application.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;

import java.time.LocalTime;

@Route(value = "time-picker-view", layout = MainLayout.class)
public class TimePickerView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Time Picker";
    }

    @Override
    protected String getDescription() {
        return "Time Picker is an input field for used entering or selecting a specific time.";
    }

    @Override
    protected Component createComponent() {
        TimePicker timePicker = new TimePicker();
        timePicker.setLabel("Alarm");
        timePicker.setValue(LocalTime.of(7, 0));
        return timePicker;
    }

    @Override
    protected String getSourceCode() {
        return """
                TimePicker timePicker = new TimePicker();
                timePicker.setLabel("Alarm");
                timePicker.setValue(LocalTime.of(7, 0));
                """;
    }
}
