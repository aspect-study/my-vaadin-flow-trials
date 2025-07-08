package com.aspect.vaadin.study.task_manager_application.views.common.ui.util;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.Arrays;

public class UiUtils {

    private UiUtils() {
        // Utility class — prevent instantiation
    }

    /**
     * Dynamically sets the Lumo theme (light or dark).
     */
    public static void setTheme(Component component, boolean dark) {
        String js = "document.documentElement.setAttribute('theme', $0)";
        component.getElement().executeJs(js, dark ? Lumo.DARK : Lumo.LIGHT);
    }

    /**
     * Creates a styled RouterLink with an icon, label, and tooltip.
     */
    public static RouterLink createNavigationLink(
            Class<? extends Component> viewClass,
            VaadinIcon icon,
            String label,
            String tooltip) {

        RouterLink link = new RouterLink(viewClass);
        Icon viewIcon = new Icon(icon);
        Span viewLabel = new Span(label);

        HorizontalLayout layout = new HorizontalLayout(viewIcon, viewLabel);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.getStyle().set("margin-left", "15px");

        link.add(layout);
        link.getElement().setAttribute("title", tooltip);

        return link;
    }

    /**
     * Wraps one or more RouterLinks in a styled VerticalLayout.
     */
    public static VerticalLayout wrapLinks(RouterLink... links) {
        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setPadding(false);
        wrapper.setSpacing(false);
        wrapper.setMargin(false);
        wrapper.setAlignItems(FlexComponent.Alignment.START);

        Arrays.stream(links).forEach(wrapper::add);
        return wrapper;
    }

}

