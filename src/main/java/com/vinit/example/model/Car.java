package com.vinit.example.model;

public interface Car {
    default void print(){
        System.out.println("In a car");
    }

    static void drive(){
        System.out.println("I am driving");
    }
}
