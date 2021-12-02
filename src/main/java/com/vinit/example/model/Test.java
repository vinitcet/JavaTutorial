package com.vinit.example.model;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Test {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setFirstName("Vinit");
        Employee e2=e;
        WeakReference<Employee> weakE= new WeakReference<>(e);
        System.out.println(weakE.get().getFirstName());
        e=null;
        e2=null;
       // System.gc();
        //System.out.println(weakE.get().getFirstName());

        WeakHashMap<String,Integer> as = new WeakHashMap<>();
        String ast="a";
        as.put(ast,1);
        System.out.println(as);
        System.gc();
        System.out.println(as);
        System.out.println(as.get(ast));
        ast= null;
        System.gc();
        System.out.println(as);
        System.out.println(as.get("a"));

        System.out.println("**************8888");
        Map<Employee, Integer> mymap= new HashMap<>();
        Employee ee = new Employee();
        ee.setFirstName("Vinit");
        mymap.put(ee,1);
        mymap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey().getFirstName() + " " + entry.getValue());
        });
        ee.setFirstName("Amit");
        mymap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey().getFirstName() + " " + entry.getValue());
        });
        ee.setFirstName("aasdf");
        mymap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey().getFirstName() + " " + entry.getValue());
        });
        ee=null;
        System.gc();
        mymap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey().getFirstName() + " " + entry.getValue());
        });

int i=32;

    }
}
