package com.aspect.vaadin.study.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Department {

    private String name;
    private String manager;
    private int employeeCount;
    private Department department;

    public Department(String name, String manager, int employeeCount) {
        this.name = name;
        this.manager = manager;
        this.employeeCount = employeeCount;
    }

    public void setParentDepartment(Department department) {this.department = department;}
    public Department getParentDepartment() {return department;}
}
