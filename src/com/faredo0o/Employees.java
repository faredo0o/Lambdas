package com.faredo0o;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Employees {
    public static void main(String[] args) {
        Employee essam=new Employee("Essam Fared",40);
        Employee omar=new Employee("Omar Essam",13);
        Employee ali=new Employee("Ali Essam Fared",7);
        Employee malek=new Employee("Malek Essam Sherifa",4);
        List<Employee> empList=new ArrayList<>();
        empList.add(essam);
        empList.add(omar);
        empList.add(ali);
        empList.add(malek);
        System.out.println("Employee over 30 :");
        System.out.println("+++++++++++++++++++");
        empList.forEach(employee -> {
           if(employee.getEmployeeAage()>30){
               System.out.println(employee.getEmployeeName());
           }
       });
        System.out.println("Employee less than 30");
        System.out.println("+++++++++++++++++++++");
        empList.forEach(employee -> {
           if(employee.getEmployeeAage()<30){
               System.out.println(employee.getEmployeeName());
           }
       });
        printEmployee(empList,"Employees more than 30 :",employee -> employee.getEmployeeAage()>30);
        printEmployee(empList,"\n Employees 30 and under : ",employee -> employee.getEmployeeAage()<=30);
        printEmployee(empList, "\n Employees less than 10 :", new Predicate<Employee>()
        {
            @Override
            public boolean test(Employee employee) {
                return employee.getEmployeeAage()<=10;
            }
        });

        IntPredicate moreThan15=i->i>15;
        IntPredicate lessThan100=i->i<100;
        System.out.println(moreThan15.and(lessThan100).test(10));
        Function<Employee,String> getLastName=employee -> {
            String lastName=employee.getEmployeeName().substring(employee.getEmployeeName().indexOf(' ')+1);
            return lastName;
        };
        Function<Employee,String> getFirstName=employee -> {
            return employee.getEmployeeName().substring(0,employee.getEmployeeName().indexOf(' '));
        };
        System.out.println(getLastName.apply(empList.get(3)));
        System.out.println(getFirstName.apply(empList.get(3)));
    }
    public static void printEmployee(List<Employee> employees, String text, Predicate<Employee> ageCondition){
        System.out.println(text);
        System.out.println("==================");
        for(Employee employee:employees){
            if(ageCondition.test(employee)){
                System.out.println(employee.getEmployeeName());
            }

        }

    }
}
