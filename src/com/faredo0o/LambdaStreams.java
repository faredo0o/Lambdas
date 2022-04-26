package com.faredo0o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaStreams {

        public static void main(String[] args) {
            List<String> someNumbers = Arrays.asList(
                    "N40", "N36",
                    "B12", "B6",
                    "G53", "G49", "G60", "G50", "g64",
                    "I26", "I17", "I29",
                    "O71");

            someNumbers.forEach(number -> {
                if (number.toUpperCase().startsWith("G")) {
                    System.out.println(number);
                }
            });
            System.out.println("====================");
            someNumbers.stream()
                    .map(String::toUpperCase)
                    .filter(s -> s.startsWith("G"))
                    .sorted()
                    .forEach(System.out::println);
            System.out.println("------------------------");
            Stream<Integer> num1 = Stream.of(1, 2, 3, 4, 5, 6);
            Stream<Integer> num2 = Stream.of(4, 5, 6, 7, 8, 9);
            Stream<Integer> concatStream = Stream.concat(num1, num2);
            System.out.println(concatStream
                    .distinct()
                    .peek(System.out::println)
                    .count());
            Employee essam = new Employee("Essam Fared", 40);
            Employee omar = new Employee("Omar Essam", 13);
            Employee ali = new Employee("Ali Essam Fared", 7);
            Employee malek = new Employee("Malek Essam Sherifa", 4);

            Department hr = new Department("Human Resources");
            hr.addEmployee(ali);
            hr.addEmployee(malek);

            Department accounting=new Department("Accounting");
            accounting.addEmployee(omar);
            accounting.addEmployee(essam);

            List<Department> departments=new ArrayList<>();
            departments.add(hr);
            departments.add(accounting);

            departments.stream().flatMap(department -> department.getEmployees().stream())
                    .forEach(System.out::println);


        }


}
