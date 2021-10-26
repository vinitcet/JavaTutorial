package com.vinit.example.test;

public class StringTester {
    public static void main(String[] args) {
        String s = "ABC";
        String s2 = new String("ABC");
        System.out.println(s == s2);
        System.out.println(s.equalsIgnoreCase(s2));
    }
}
