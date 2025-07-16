package com.aspect.vaadin.study.views.dashboards;

import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard-view", layout = MainLayout.class)
public class DashboardView extends VerticalLayout {

    public DashboardView() {
        setPadding(true);
        setSpacing(true);

        H1 title = new H1("Dashboard");

        HorizontalLayout stats = new HorizontalLayout();
        stats.setWidthFull();

        VerticalLayout usersCard = createStatCard("Users", "1,245", "#e3f2fd");     // Light blue
        VerticalLayout salesCard = createStatCard("Sales", "$12,430", "#fce4ec");   // Light pink
        VerticalLayout growthCard = createStatCard("Growth", "8.2%", "#e8f5e9");    // Light green

        stats.add(usersCard, salesCard, growthCard);

        Grid<String> recentActivity = new Grid<>();
        recentActivity.addColumn(item -> item).setHeader("Recent Activity");
        recentActivity.setItems("Admin (aspect) logged in", "User A signed up", "Order #1234 placed", "New comment on blog");

        add(title, stats, recentActivity);
    }

    private VerticalLayout createStatCard(String label, String value, String bgColor) {
        Span title = new Span(label);
        title.getStyle().set("font-weight", "bold");
        title.getStyle().set("color", "#000000");


        Span number = new Span(value);
        number.getStyle().set("font-size", "1.5em");
        number.getStyle().set("color", "#000000");


        VerticalLayout card = new VerticalLayout(title, number);
        card.getStyle()
                .set("padding", "1em")
                .set("border", "1px solid #ccc")
                .set("border-radius", "8px")
                .set("background-color", bgColor);
        return card;
    }
}