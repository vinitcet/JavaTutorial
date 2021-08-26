package com.vinit.example.model;

/**
 *
 */
public class Vechicle implements Car ,FourWheeler{

    @Override
    public void print() {

    }

    public static void main(String[] args) {
        Car.drive();
    }
}
