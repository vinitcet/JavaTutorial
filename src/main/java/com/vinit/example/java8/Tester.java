package com.vinit.example.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Vinit", 20);
        Employee emp2 = new Employee("Amit", 30);
        Employee emp3 = new Employee("Priya", 40);
        Employee emp4 = new Employee("babu", 10);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        //Given a list of employees, you need to filter all the employee whose age is greater than 20 and print the employee names.
        employeeList.stream().filter(e -> e.getAge() > 20).forEach(e -> System.out.println(e.getName()));
        //Given the list of employees, count number of employees with age 25?
        //System.out.println(employeeList.stream().filter(e->e.getAge()>25).collect(Collectors.counting()));
        System.out.println(employeeList.stream().filter(e -> e.getAge() > 25).count());
        //Given the list of employees, find the employee with name “Mary”
        Optional<Employee> emp = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase("Babu")).findAny();
        if (emp.isPresent()) {
            System.out.println(emp.get());
        }
        //Given a list of employee, find maximum age of employee
        System.out.println(employeeList.stream().mapToInt(e -> e.getAge()).max().getAsInt());
        //Given a list of employees, sort all the employee on the basis of age? Use java 8 APIs only
        employeeList.stream().sorted((e1,e2)->e1.getAge()- e2.getAge()).forEach(System.out::println);
        //Join the all employee names with “,” using java 8?
        System.out.println(
        employeeList
                .stream()
                .map(Employee::getName).collect(Collectors.joining(",")).toString());
        //Given the list of employee, group them by employee name?
        // Map<String, List<Employee>> map
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getName)));
        //Given the list of numbers, remove the duplicate elements from the list.
        Integer[] arr=new Integer[]{1,2,3,4,3,2,4,2};
        List<Integer> listWithDuplicates = Arrays.asList(arr);
        listWithDuplicates.stream().collect(Collectors.toSet()).forEach(System.out::print);
        listWithDuplicates.stream().distinct().forEach(System.out::print);
        //Given a list of numbers, square them and filter the numbers which are greater 10000 and then find average of them.( Java 8 APIs only)
        Integer[] arr2=new Integer[]{100,24,13,44,114,200,40,112};
        List<Integer> list = Arrays.asList(arr2);
        System.out.println(list.stream().mapToInt(s->s*s).filter(s->s>10000).average().getAsDouble());
        Supplier<Double> sup =()->Math.random();
        System.out.println(sup.get());
       // () -> StringJoiner(",")
        //print ten random numbers using forEach?
        new Random().ints().limit(10).forEach(System.out::println);
        //How do you get the highest number that exists on a list?
        System.out.println(list.stream().mapToInt(Integer::intValue).max().getAsInt());
        System.out.println(list.stream().mapToInt(x->x).summaryStatistics());
        LocalDate ld =LocalDate.now();
        LocalDate friday =ld.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(friday);
        //SecondHighestAge
        System.out.println(employeeList.stream().map(Employee::getAge).sorted(Comparator.reverseOrder()).limit(2).mapToInt(Integer::intValue).min().getAsInt());
    }
}
