package com.aspect.vaadin.study.views.forminputs;

import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Route(value = "combo-box-view", layout = MainLayout.class)
public class ComboBoxView extends ComponentView {

    @Override
    protected String getTitle() {
        return "Combo Box";
    }

    @Override
    protected String getDescription() {
        return """
                Combo Box allows the user to choose a value from a filterable list of options presented in an overlay.
                It supports lazy loading and can be configured to accept custom typed values.
                """;
    }

    @Override
    protected Component createComponent() {
        Paragraph description = new Paragraph("The overlay opens when the user clicks the field using a pointing device. Using the Up/Down arrow keys or typing a character found in at least one of the options when the field is focused also opens the popup.");
        ComboBox<String> comboBox = new ComboBox<>("Country");
        comboBox.setItems(Arrays.stream(Locale.getISOCountries())
                .map(code -> new Locale.Builder().setRegion(code).build().getDisplayCountry())
                .sorted()
                .toList());
        comboBox.setItemLabelGenerator(country -> country);
        HorizontalLayout displayComboBoxDefaultValue = new HorizontalLayout();
        displayComboBoxDefaultValue.setVerticalComponentAlignment(Alignment.END, description);
        displayComboBoxDefaultValue.add(comboBox, description);

        description = new Paragraph("Combo Box can be configured to allow entering custom values that aren’t included in the list of options. Allowing custom entry is useful when you need to present the most common choices, but still give users the freedom to enter their own options.");
        List<String> browser = List.of("Chrome", "Safari", "Internet Explorer");
        ComboBox<String> comboBoxCustomValue = new ComboBox<>("Browser");
        comboBoxCustomValue.setItems(browser);
        comboBoxCustomValue.setAllowCustomValue(true);
        HorizontalLayout displayComboBoxCustomValue = new HorizontalLayout();
        displayComboBoxCustomValue.setVerticalComponentAlignment(Alignment.END, description);
        displayComboBoxCustomValue.add(comboBoxCustomValue, description);

        VerticalLayout displayComboBoxComponent = new VerticalLayout();
        displayComboBoxComponent.add(displayComboBoxDefaultValue, displayComboBoxCustomValue);
        return displayComboBoxComponent;
    }

    @Override
    protected String getSourceCode() {
        return """
                Paragraph description = new Paragraph("The overlay opens when the user clicks the field using a pointing device. Using the Up/Down arrow keys or typing a character found in at least one of the options when the field is focused also opens the popup.");
                ComboBox<String> comboBox = new ComboBox<>("Country");
                comboBox.setItems(Arrays.stream(Locale.getISOCountries())
                        .map(code -> new Locale.Builder().setRegion(code).build().getDisplayCountry())
                        .sorted()
                        .toList());
                comboBox.setItemLabelGenerator(country -> country);
                HorizontalLayout displayComboBoxDefaultValue = new HorizontalLayout();
                displayComboBoxDefaultValue.setVerticalComponentAlignment(Alignment.END, description);
                displayComboBoxDefaultValue.add(comboBox, description);
                
                description = new Paragraph("Combo Box can be configured to allow entering custom values that aren’t included in the list of options. Allowing custom entry is useful when you need to present the most common choices, but still give users the freedom to enter their own options.");
                List<String> browser = List.of("Chrome", "Safari", "Internet Explorer");
                ComboBox<String> comboBoxCustomValue = new ComboBox<>("Browser");
                comboBoxCustomValue.setItems(browser);
                comboBoxCustomValue.setAllowCustomValue(true);
                HorizontalLayout displayComboBoxCustomValue = new HorizontalLayout();
                displayComboBoxCustomValue.setVerticalComponentAlignment(Alignment.END, description);
                displayComboBoxCustomValue.add(comboBoxCustomValue, description);
                
                VerticalLayout displayComboBoxComponent = new VerticalLayout();
                displayComboBoxComponent.add(displayComboBoxDefaultValue, displayComboBoxCustomValue);
                """;
    }
}
