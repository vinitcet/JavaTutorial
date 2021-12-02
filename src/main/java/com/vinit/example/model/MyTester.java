package com.vinit.example.model;

public class MyTester {

    public static void main(String[] args) {
        MyTester mt = new MyTester();
       // mt.print(null);
    }

    void print(Integer i) {
        System.out.println("Integer " + i);
    }

    void print(String i) {
        System.out.println("String " + i);
    }
}
