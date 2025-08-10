package com.aspect.vaadin.study.views.datadisplay;

import com.aspect.vaadin.study.data.Department;
import com.aspect.vaadin.study.data.Person;
import com.aspect.vaadin.study.views.common.ui.util.abstractcomponent.ComponentView;
import com.aspect.vaadin.study.views.main.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.data.provider.hierarchy.TreeData;
import com.vaadin.flow.data.provider.hierarchy.TreeDataProvider;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Route(value = "tree-grid-view", layout = MainLayout.class)
public class TreeGridView extends ComponentView {

    @Override
    protected String getTitle() {
        return "TreeGrid View";
    }

    @Override
    protected String getDescription() {
        return "Tree Grid is a component for displaying hierarchical tabular data grouped into expandable nodes.";
    }

    @Override
    protected Component createComponent() {
        Accordion accordion = new Accordion();
        accordion.setWidthFull();
        accordion.add(getTreeGridDemo1());

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(accordion);
        return verticalLayout;
    }

    private AccordionPanel getTreeGridDemo1() {
        List<Department> departmentList = createDepartments();

        TreeGrid<Department> departmentTreeGrid = new TreeGrid<>();
        departmentTreeGrid.addHierarchyColumn(Department::getName).setHeader("Department Name");
        departmentTreeGrid.addColumn(Department::getManager).setHeader("Manager");
        departmentTreeGrid.addColumn(Department::getEmployeeCount).setHeader("Employees");

        TreeData<Department> treeData = new TreeData<>();

        //top or root
        departmentList.stream()
                .filter(department -> department.getParentDepartment() == null)
                .forEach(department ->
                        treeData.addItems(null, department));

        //child
        departmentList.stream()
                .filter(department -> department.getParentDepartment() != null)
                .forEach(department ->
                        treeData.addItems(department.getParentDepartment(), department));

        departmentTreeGrid.setDataProvider(new TreeDataProvider<>(treeData));

        departmentTreeGrid.expandRecursively(departmentList.stream()
                .filter(department -> department.getParentDepartment() == null)
                .toList(), 0);

        AccordionPanel accordionPanel = new AccordionPanel(
                "Demo Tree Grid Component",
                departmentTreeGrid);
        accordionPanel.setWidthFull();
        return accordionPanel;
    }

    private ArrayList<Department> createDepartments() {
        var departments = new ArrayList<Department>();
        //Root
        Department executive = new Department("Executive", "CEO", 3);
        Department sales = new Department("Sale", "Sales Director", 15);
        Department engineering = new Department("Engineering", "CTO", 42);

        //Sub
        Department marketing = new Department("Marketing", "Marketing Manager", 8);
        marketing.setParentDepartment(sales);
        Department salesOperation = new Department("Sales Operation", "Sales Manager", 7);
        salesOperation.setParentDepartment(sales);

        Department development = new Department("Development", "Dev Manager", 25);
        development.setParentDepartment(engineering);
        Department qa = new Department("Quality Assurance", "QA Manager", 25);
        qa.setParentDepartment(engineering);
        Department devOps = new Department("DevOps", "DevOps Manager", 25);
        devOps.setParentDepartment(engineering);

        departments.add(executive);
        departments.add(sales);
        departments.add(engineering);

        departments.add(marketing);
        departments.add(salesOperation);

        departments.add(development);
        departments.add(qa);
        departments.add(devOps);

        return departments;
    }

    @Override
    protected String getSourceCode() {
        return """ 
                protected Component createComponent() {
                    Accordion accordion = new Accordion();
                    accordion.setWidthFull();
                    accordion.add(getTreeGridDemo1());
                
                    VerticalLayout verticalLayout = new VerticalLayout();
                    verticalLayout.add(accordion);
                    return verticalLayout;
                }
                
                private AccordionPanel getTreeGridDemo1() {
                    List<Department> departmentList = createDepartments();
                
                    TreeGrid<Department> departmentTreeGrid = new TreeGrid<>();
                    departmentTreeGrid.addHierarchyColumn(Department::getName).setHeader("Department Name");
                    departmentTreeGrid.addColumn(Department::getManager).setHeader("Manager");
                    departmentTreeGrid.addColumn(Department::getEmployeeCount).setHeader("Employees");
                
                    TreeData<Department> treeData = new TreeData<>();
                
                    //top or root
                    departmentList.stream()
                            .filter(department -> department.getParentDepartment() == null)
                            .forEach(department ->
                                    treeData.addItems(null, department));
                
                    //child
                    departmentList.stream()
                            .filter(department -> department.getParentDepartment() != null)
                            .forEach(department ->
                                    treeData.addItems(department.getParentDepartment(), department));
                
                    departmentTreeGrid.setDataProvider(new TreeDataProvider<>(treeData));
                
                    departmentTreeGrid.expandRecursively(departmentList.stream()
                            .filter(department -> department.getParentDepartment() == null)
                            .toList(), 0);
                
                    AccordionPanel accordionPanel = new AccordionPanel(
                            "Demo Tree Grid Component",
                            departmentTreeGrid);
                    accordionPanel.setWidthFull();
                    return accordionPanel;
                }
                
                private ArrayList<Department> createDepartments() {
                    var departments = new ArrayList<Department>();
                    //Root
                    Department executive = new Department("Executive", "CEO", 3);
                    Department sales = new Department("Sale", "Sales Director", 15);
                    Department engineering = new Department("Engineering", "CTO", 42);
                
                    //Sub
                    Department marketing = new Department("Marketing", "Marketing Manager", 8);
                    marketing.setParentDepartment(sales);
                    Department salesOperation = new Department("Sales Operation", "Sales Manager", 7);
                    salesOperation.setParentDepartment(sales);
                
                    Department development = new Department("Development", "Dev Manager", 25);
                    development.setParentDepartment(engineering);
                    Department qa = new Department("Quality Assurance", "QA Manager", 25);
                    qa.setParentDepartment(engineering);
                    Department devOps = new Department("DevOps", "DevOps Manager", 25);
                    devOps.setParentDepartment(engineering);
                
                    departments.add(executive);
                    departments.add(sales);
                    departments.add(engineering);
                
                    departments.add(marketing);
                    departments.add(salesOperation);
                
                    departments.add(development);
                    departments.add(qa);
                    departments.add(devOps);
                
                    return departments;
                }""";
    }

}
