package com.aspect.vaadin.study.views.datadisplay;

import com.aspect.vaadin.study.data.Person;
import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
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

        Accordion accordion = new Accordion();
        accordion.setWidthFull();
        accordion.add(getGridDemo1());
        accordion.add(getGridDemo2());

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(accordion);
        return verticalLayout;
    }

    private AccordionPanel getGridDemo1() {
        Grid<Person> personGrid = new Grid<>(Person.class);
        personGrid.setItems(createSampleDateOfPerson());
        AccordionPanel accordionPanel =
                new AccordionPanel("Demo Grid Component - Automatic column generation", personGrid);
        accordionPanel.setWidthFull();
        return accordionPanel;
    }

    private AccordionPanel getGridDemo2() {
        Grid<Person> personGrid = new Grid<>();
        personGrid.addColumn(Person::getFirstName).setHeader(new H3("First Name"));
        personGrid.addColumn(Person::getLastName).setHeader(new H3("Last Name"));
        personGrid.addColumn(Person::getEmail).setHeader(new H3("Email Address"));
        personGrid.setItems(createSampleDateOfPerson());
        AccordionPanel accordionPanel =
                new AccordionPanel("Demo Grid Component - Manual column definition (more control)", personGrid);
        accordionPanel.setWidthFull();
        return accordionPanel;
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

    @Override
    protected String getSourceCode() {
        return """
                @Override
                protected Component createComponent() {
                
                    Accordion accordion = new Accordion();
                    accordion.setWidthFull();
                    accordion.add(getGridDemo1());
                    accordion.add(getGridDemo2());
                
                    VerticalLayout verticalLayout = new VerticalLayout();
                    verticalLayout.add(accordion);
                    return verticalLayout;
                }
                
                private AccordionPanel getGridDemo1() {
                    Grid<Person> personGrid = new Grid<>(Person.class);
                    personGrid.setItems(createSampleDateOfPerson());
                    AccordionPanel accordionPanel =
                            new AccordionPanel("Demo Grid Component - Automatic column generation", personGrid);
                    accordionPanel.setWidthFull();
                    return accordionPanel;
                }
                
                private AccordionPanel getGridDemo2() {
                    Grid<Person> personGrid = new Grid<>();
                    personGrid.addColumn(Person::getFirstName).setHeader(new H3("First Name"));
                    personGrid.addColumn(Person::getLastName).setHeader(new H3("Last Name"));
                    personGrid.addColumn(Person::getEmail).setHeader(new H3("Email Address"));
                    personGrid.setItems(createSampleDateOfPerson());
                    AccordionPanel accordionPanel =
                            new AccordionPanel("Demo Grid Component - Manual column definition (more control)", personGrid);
                    accordionPanel.setWidthFull();
                    return accordionPanel;
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
                """;
    }
}
