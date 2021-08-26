package com.vinit.example.model;

public interface FourWheeler {
    default void print(){
        System.out.println("In a 4 wheeler");
    }
}
