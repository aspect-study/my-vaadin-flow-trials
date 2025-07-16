package com.aspect.vaadin.study.views.main;

import com.aspect.vaadin.study.views.buttons.ButtonView;
import com.aspect.vaadin.study.views.common.ui.util.UiUtils;
import com.aspect.vaadin.study.views.common.ui.util.wrapper.LinkConfig;
import com.aspect.vaadin.study.views.dashboards.DashboardView;
import com.aspect.vaadin.study.views.datadisplay.GridView;
import com.aspect.vaadin.study.views.forminputs.*;
import com.aspect.vaadin.study.views.layouts.HorizontalLayoutView;
import com.aspect.vaadin.study.views.layouts.VerticalLayoutView;
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

import java.util.List;

@Route("")
public class MainLayout extends AppLayout implements HasDynamicTitle {

    public MainLayout() {
        var themeToggle = new Checkbox("Dark theme");
        themeToggle.setValue(true);
        if(themeToggle.getValue()) {
            UiUtils.setTheme(themeToggle,true);
        }
        themeToggle.addValueChangeListener(
                e ->
                UiUtils.setTheme(themeToggle, e.getValue()));

        H2 title = new H2("Study with aspect; | Java - Vaadin Flow - User Interface Framework");
        title.getStyle().set("margin", "0");

        Avatar aspectAvatar = new Avatar("Aspect");
        aspectAvatar.setImage("https://robohash.org/1c8e8a6e8d1fe52b782b280909abeb38?set=set4&bgset=&size=400x400");
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

        VerticalLayout menu = getHomeLayout();
        addToDrawer(menu);

        Accordion formInputAccordion = new Accordion();
        formInputAccordion.add("Form Inputs", getFormInputLayout());
        formInputAccordion.add("Button and Actions", getButtonAndActionMenu());
        formInputAccordion.add("Data Display", getDataDisplayMenu());
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

    private static VerticalLayout getHomeLayout() {
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

    public static VerticalLayout getFormInputLayout() {
        List<LinkConfig> linkConfigs = List.of(
                new LinkConfig(TextFieldView.class,VaadinIcon.TEXT_INPUT,
                        "text-field-view", "Navigate to text field View"),
                new LinkConfig(PasswordFieldView.class,VaadinIcon.PASSWORD,
                        "password-field-view", "Navigate to password field View"),
                new LinkConfig(TextAreaView.class,VaadinIcon.FILE_TEXT,
                        "text-area-view", "Navigate to text area view"),
                new LinkConfig(EmailFieldView.class,VaadinIcon.ENVELOPE,
                        "email-field-view", "Navigate to email field view"),
                new LinkConfig(NumberFieldView.class,VaadinIcon.PHONE,
                        "number-field-view", "Navigate to number field view"),
                new LinkConfig(IntegerFieldView.class,VaadinIcon.PHONE_LANDLINE,
                        "integer-field-view", "Navigate to integer field view"),
                new LinkConfig(BigDecimalFieldView.class,VaadinIcon.MONEY,
                        "big-decimal-field-view", "Navigate to big decimal field view"),
                new LinkConfig(CheckboxView.class,VaadinIcon.CHECK_SQUARE,
                        "checkbox-field-view", "Navigate to checkbox view"),
                new LinkConfig(GroupCheckboxView.class,VaadinIcon.CHECK_SQUARE,
                        "group-checkbox-view", "Navigate to group checkbox view"),
                new LinkConfig(RadioButtonGroupView.class,VaadinIcon.CIRCLE,
                        "radio-button-view", "Navigate to group radio button view"),
                new LinkConfig(SelectView.class,VaadinIcon.SELECT,
                        "select-view", "Navigate to select view"),
                new LinkConfig(ComboBoxView.class,VaadinIcon.COMBOBOX,
                        "combo-box-view", "Navigate to combo box view"),
                new LinkConfig(ListBoxView.class,VaadinIcon.LIST,
                        "list-box-view", "Navigate to list box view"),
                new LinkConfig(DatePickerView.class,VaadinIcon.DATE_INPUT,
                        "date-picker-view", "Navigate to date picker view"),
                new LinkConfig(TimePickerView.class,VaadinIcon.TIME_FORWARD,
                        "time-picker-view", "Navigate to time picker view")
        );
        return UiUtils.createNavigationLayout(linkConfigs);
    }

    private static VerticalLayout getButtonAndActionMenu() {

        List<LinkConfig> linkConfigs = List.of(
                new LinkConfig(ButtonView.class,VaadinIcon.BUTTON, "button-view", "Navigate to Button View")
        );
        return UiUtils.createNavigationLayout(linkConfigs);
    }

    private static VerticalLayout getDataDisplayMenu() {
        List<LinkConfig> linkConfigs = List.of(
                new LinkConfig(GridView.class,VaadinIcon.GRID, "grid-view", "Navigate to grid View")
                );
        return UiUtils.createNavigationLayout(linkConfigs)  ;
    }

    private static VerticalLayout getLayoutMenu() {

        List<LinkConfig> linkConfigs = List.of(
                new LinkConfig(HorizontalLayoutView.class,VaadinIcon.ARROW_RIGHT, "horizontal-view", "Navigate to horizontal view"),
                new LinkConfig(VerticalLayoutView.class,VaadinIcon.ARROW_DOWN, "vertical-view", "Navigate to vertical view")
        );

        return UiUtils.createNavigationLayout(linkConfigs);
    }

    @Override
    public String getPageTitle() {
        return "Study with aspect;";
    }
}
