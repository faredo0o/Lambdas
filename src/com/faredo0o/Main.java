package com.faredo0o;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        new Thread(()-> System.out.println("Printing From the Runnable Lambda")).start();

        Employee essam=new Employee("Essam",40);
        Employee omar=new Employee("Omar",13);
        Employee ali=new Employee("Ali",7);
        Employee malek=new Employee("Malek",4);
        List<Employee> empList=new ArrayList<>();
        empList.add(essam);
        empList.add(omar);
        empList.add(ali);
        empList.add(malek);
//        Collections.sort(empList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getEmployeeName().compareTo(employee2.getEmployeeName());
//            }
//        });
        Collections.sort(empList,( employee1, employee2)->
                employee1.getEmployeeName().compareTo(employee2.getEmployeeName()));
        for(Employee emp:empList){
            System.out.println(emp.getEmployeeName());
        }
        System.out.println("********************");
        empList.forEach((Employee emp)-> {
            System.out.println(emp.getEmployeeName());
            System.out.println(emp.getEmployeeAage());
        });
//        String anyString=doStringStuff(new UpperConcat() {
//            @Override
//            public String upperConcat(String s1, String s2) {
//                return s1.toUpperCase()+" "+s2.toUpperCase();
//            }
//        },empList.get(0).getEmployeeName(),empList.get(1).getEmployeeName());
//        System.out.println(anyString);
        UpperConcat uc=(s1,s2)->s1.toUpperCase()+" "+s2.toUpperCase();
        String someString=doStringStuff(uc,empList.get(0).getEmployeeName()
                ,empList.get(1).getEmployeeName());
        System.out.println(someString);
  }
    public static String doStringStuff(UpperConcat uc,String s1,String s2){

        return uc.upperConcat(s1,s2);
    }
}
class Employee{
    private String employeeName;
    private int employeeAage;

    public Employee(String employeeName, int employeeAage) {
        this.employeeName = employeeName;
        this.employeeAage = employeeAage;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeAage() {
        return employeeAage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                '}';
    }
}
interface UpperConcat {

    public String upperConcat(String s1, String s2);
}