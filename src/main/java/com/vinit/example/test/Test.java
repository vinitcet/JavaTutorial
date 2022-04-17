package com.vinit.example.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;


public class Test {


    public static void main(String[] args) throws IOException {
        Set s = new LinkedHashSet<>();
        s.add("1");
        s.add(1);
        s.add(3);
        s.add(2);
        System.out.println(s);


    }
}