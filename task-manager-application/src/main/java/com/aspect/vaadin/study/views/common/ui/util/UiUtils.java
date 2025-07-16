package com.aspect.vaadin.study.views.common.ui.util;

import com.aspect.vaadin.study.views.common.ui.util.wrapper.LinkConfig;
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
import java.util.List;

public class UiUtils {

    private UiUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Sets the global theme (light or dark) based on the provided toggle value.
     * Executes JavaScript to apply the theme to the HTML root element.
     *
     * @param component the {@code Component} used to invoke the JavaScript execution
     * @param dark      {@code true} to apply the {@code Lumo.DARK} theme, {@code false} for {@code Lumo.LIGHT}
     */
    public static void setTheme(Component component, boolean dark) {
        String js = "document.documentElement.setAttribute('theme', $0)";
        component.getElement().executeJs(js, dark ? Lumo.DARK : Lumo.LIGHT);
    }

    /**
     * Creates a styled {@link RouterLink} with an icon, label, and tooltip,
     * arranged horizontally for use in navigation layouts.
     *
     * @param viewClass the target view class to navigate to
     * @param icon      the {@link VaadinIcon} to display alongside the label
     * @param label     the visible label text for the link
     * @param tooltip   the descriptive text shown on hover
     * @return a styled {@code RouterLink} component with icon, label, and tooltip
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
     * Wraps multiple {@link RouterLink} components in a {@link VerticalLayout}.
     *
     * @param links the {@code RouterLink} components to include in the vertical layout
     * @return a {@code VerticalLayout} containing the provided {@code RouterLink} components,
     * with no padding, spacing, or margin, and left-aligned
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

    public static VerticalLayout createNavigationLayout(List<LinkConfig> linkConfigs) {
        RouterLink[] routerLinks = linkConfigs.stream()
                .map(linkConfig ->
                        createNavigationLink(
                                linkConfig.getViewClass(),
                                linkConfig.getIcon(),
                                linkConfig.getRouterId(),
                                linkConfig.getDescription()))
                .toArray(RouterLink[]::new);
        return wrapLinks(routerLinks);
    }

}

