package com.vinit.example.java8;

@FunctionalInterface
public interface FunInterface {

    void print();

    default void printHello(){
        System.out.println("Hello");
    }

    public static void getHello(){
        System.out.println("In static method");
    }

    public static void getHello2(){
        System.out.println("In static method2");
    }

    default void printHello2(){
        System.out.println("Hello2");
    }
}
