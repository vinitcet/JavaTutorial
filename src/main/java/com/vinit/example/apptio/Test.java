package com.vinit.example.apptio;

import com.vinit.example.java8.Employee;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Employee emp = new Employee("apptio", 20);
        Map<String, Integer> map = new HashMap<>();
        map.put(emp.getName(), emp.getAge());
        emp.setName("apptio01");
        System.out.println(map.get("apptio"));
    }
}
