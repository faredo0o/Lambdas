package com.faredo0o;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public List<Employee> getEmployees(){
        return employees;
    }

}
