package com.aspect.vaadin.study.views.datadisplay;

import com.aspect.vaadin.study.data.Person;
import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Route(value = "virtual-list-view", layout = MainLayout.class)
public class VirtualListView  extends ComponentView {

    @Override
    protected String getTitle() {
        return "Virtual List";
    }

    @Override
    protected String getDescription() {
        return """
                Virtual List allows you to render a long list of items inside a scrollable container without sacrificing performance. Each item is rendered on the fly as the user scrolls the list.
                To use this component, you need to assign it a set of data items and a renderer that’s used to render each individual data item. The height of an item is determined by its content and can change dynamically.
                """;
    }

    @Override
    protected Component createComponent() {
        VirtualList<Person> virtualList = new VirtualList<>();
        virtualList.setItems(getListOfPerson());

        virtualList.setRenderer(new ComponentRenderer<>( person -> {
             Div name = new Div();
             name.setText(person.getFirstName());

             return name;
        }));

        return virtualList;
    }

    private List<Person> getListOfPerson() {
        return IntStream
                .rangeClosed(1, 1000)
                .mapToObj(i -> new Person("Name"+i, "LastName"+i,
                        "sample"+i+"@email.com"))
                .toList();
    }

    @Override
    protected String getSourceCode() {
        return "";
    }
}
