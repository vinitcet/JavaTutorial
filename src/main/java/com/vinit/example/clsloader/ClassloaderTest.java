package com.vinit.example.clsloader;

import com.sun.tools.javac.Main;

import java.util.HashMap;
import java.util.List;

public class ClassloaderTest {
    public static void main(String[] args) {
        System.out.println(ClassloaderTest.class.getClassLoader());

        System.out.println( ClassloaderTest.class.getCanonicalName());


    }
}
