package com.aspect.vaadin.study.views.datadisplay;

import com.aspect.vaadin.study.data.Person;
import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

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
        paragraph.setText("Demo Grid Component");

        Grid<Person> personGrid = new Grid<>(Person.class);
        personGrid.setItems(createSampleDateOfPerson());

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(paragraph, personGrid);
        return verticalLayout;
    }

    @Override
    protected String getSourceCode() {
        return """
                Paragraph paragraph = new Paragraph();
                paragraph.setText("Demo Grid Component");
                
                Grid<Person> personGrid = new Grid<>(Person.class);
                personGrid.setItems(createSampleDateOfPerson());
                
                VerticalLayout verticalLayout = new VerticalLayout();
                verticalLayout.add(paragraph, personGrid);
                """;
    }

    private List<Person> createSampleDateOfPerson() {
        return List.of(
                new Person("Aspect", "Jump", "aspect@test.com"),
                new Person("Wellingtoncs86", "User", "Wellingtoncs86@test.com"),
                new Person("amts", "User", "amts@test.com"),
                new Person("Rommel", "Dacillio", "Rommel@test.com"),
                new Person("BIBAS", "ART", "BIBAS@test.com"),
                new Person("JustinB", "ph", "JustinB@test.com"),
                new Person("markue", "user", "markue@test.com"),
                new Person("Ryle", "haha", "Ryle@test.com"),
                new Person("Ice", "Cream", "Ice@test.com"),
                new Person("itz", "me", "itz@test.com")
        );
    }
}
