package com.aspect.vaadin.study.task_manager_application.views.main;

import com.aspect.vaadin.study.task_manager_application.views.buttons.ButtonView;
import com.aspect.vaadin.study.task_manager_application.views.common.ui.util.UiUtils;
import com.aspect.vaadin.study.task_manager_application.views.dashboards.DashboardView;
import com.aspect.vaadin.study.task_manager_application.views.forminputs.TextFieldView;
import com.aspect.vaadin.study.task_manager_application.views.layouts.HorizontalLayoutView;
import com.aspect.vaadin.study.task_manager_application.views.layouts.VerticalLayoutView;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import org.jetbrains.annotations.NotNull;

@Route("")
public class MainLayout extends AppLayout implements HasDynamicTitle {

    public MainLayout() {
        var themeToggle = new Checkbox("Dark theme");
        themeToggle.setValue(true);
        if(themeToggle.getValue()) {
            UiUtils.setTheme(themeToggle,true);
        }
        themeToggle.addValueChangeListener(
                e -> {
                    UiUtils.setTheme(themeToggle, e.getValue());
                });

        H2 title = new H2("Study with aspect;");
        title.getStyle().set("margin", "0");

        Avatar aspectAvatar = new Avatar("Aspect");
        aspectAvatar.setImage("https://gravatar.com/avatar/27f11583af9e6a3411972f0fed1fe469?s=400&d=robohash&r=x");
        aspectAvatar.getStyle().set("margin-left", "auto");
        aspectAvatar.getStyle().set("background-color", "#000000");
        aspectAvatar.getElement().getThemeList().add("large");

        DrawerToggle toggle = new DrawerToggle();
        toggle.setIcon(new Icon(VaadinIcon.MENU));

        HorizontalLayout header = new HorizontalLayout(toggle, title, aspectAvatar,themeToggle);
        header.setVerticalComponentAlignment(FlexComponent.Alignment.START);
        header.setWidthFull();
        header.getStyle().set("padding", "var(--lumo-space-s)");
        addToNavbar(header);

        VerticalLayout menu = getVerticalLayout();
        addToDrawer(menu);

        Accordion formInputAccordion = new Accordion();
        formInputAccordion.add("Form Inputs", getFormInputLayout());
        formInputAccordion.add("Button and Actions", getButtonAndActionMenu());
//        formInputAccordion.add("Data Display", new VerticalLayout());
        formInputAccordion.add("Layouts", getLayoutMenu());
//        formInputAccordion.add("Dialogs & Notifications", new VerticalLayout());
//        formInputAccordion.add("Navigation & Routing", new VerticalLayout());
//        formInputAccordion.add("Miscellaneous", new VerticalLayout());
//        formInputAccordion.add("Utility Components", new VerticalLayout());
//        formInputAccordion.add("Vaadin Chart.js Wrapper (Community)", new VerticalLayout());
//        formInputAccordion.add("Apache POI + Vaadin Grid", new VerticalLayout());
//        formInputAccordion.add("Vaadin Layouts + CSS Grid or FlexLayout", new VerticalLayout());
//        formInputAccordion.add("Vaadin ContextMenu (Free Component)", new VerticalLayout());
//        formInputAccordion.add("Manual CRUD using Grid + Binder + Dialog", new VerticalLayout());
//        formInputAccordion.add("vis-timeline JS + WebComponent", new VerticalLayout());
//        formInputAccordion.add("vPDF.js + <iframe> or <object> in Vaadin", new VerticalLayout());
        addToDrawer(formInputAccordion);
    }

    private void setTheme(boolean dark) {
        var js = "document.documentElement.setAttribute('theme', $0)";
        getElement().executeJs(js, dark ? Lumo.DARK : Lumo.LIGHT);
    }
    @NotNull
    public static VerticalLayout getFormInputLayout() {

//        RouterLink testFieldView = new RouterLink(TextFieldView.class);
//        Icon textFieldIcon = new Icon(VaadinIcon.TEXT_INPUT);
//        Span testFieldText = new Span("text-field-view");
//        HorizontalLayout textFieldLayout = new HorizontalLayout(textFieldIcon,testFieldText);
//        textFieldLayout.setAlignItems(FlexComponent.Alignment.CENTER);
//        textFieldLayout.getStyle().set("margin-left", "15px");
//        testFieldView.add(textFieldLayout);
//        testFieldView.getElement().setAttribute("title", "Navigate to Text Field View");
//
//        VerticalLayout layoutMenu = new VerticalLayout();
//        layoutMenu.add(testFieldView);

        RouterLink testFieldView = UiUtils.createNavigationLink(
                TextFieldView.class,
                VaadinIcon.TEXT_INPUT,
                "text-field-view",
                "Navigate to Text Field View");

        return UiUtils.wrapLinks(testFieldView);
    }
    @NotNull
    private static VerticalLayout getButtonAndActionMenu() {

        RouterLink buttonView = UiUtils.createNavigationLink(
                ButtonView.class,
                VaadinIcon.BUTTON,
                "button-view",
                "Navigate to Button View");

        return UiUtils.wrapLinks(buttonView);
    }
    @NotNull
    private static VerticalLayout getLayoutMenu() {

        RouterLink horizontalView = new RouterLink("", HorizontalLayoutView.class);
        Span horizontalText = new Span("Horizontal-view");
        Icon horizontalViewIcon = new Icon(VaadinIcon.ARROW_RIGHT);
        HorizontalLayout horizontalLayout = new HorizontalLayout(horizontalViewIcon, horizontalText);
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        horizontalLayout.getStyle().set("margin-left", "15px");
        horizontalView.add(horizontalLayout);

        RouterLink verticalView = new RouterLink("", VerticalLayoutView.class);
        Span verticalText = new Span("Vertical-view");
        Icon verticalViewIcon = new Icon(VaadinIcon.ARROW_DOWN);
        HorizontalLayout verticalLayout = new HorizontalLayout(verticalViewIcon, verticalText);
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        horizontalLayout.getStyle().set("margin-left", "15px");
        verticalView.add(verticalLayout);

        VerticalLayout layoutMenu = new VerticalLayout();
        layoutMenu.add(horizontalView,verticalView);

        return layoutMenu;
    }

    @NotNull
    private static VerticalLayout getVerticalLayout() {
        RouterLink homeView = new RouterLink("", DashboardView.class);
        Span homeText = new Span("Home-view");
        Icon homeIcon = new Icon(VaadinIcon.HOME);
        HorizontalLayout homeLayout = new HorizontalLayout(homeIcon, homeText);
        homeLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        homeView.add(homeLayout);

        VerticalLayout menu = new VerticalLayout(homeView);
        menu.setAlignItems(FlexComponent.Alignment.START);

        return menu;
    }

    @Override
    public String getPageTitle() {
        return "Study with aspect;";
    }
}
