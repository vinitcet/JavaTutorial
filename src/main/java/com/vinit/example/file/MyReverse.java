package com.vinit.example.file;

public class MyReverse {

    public static void main(String[] args) {
        String[] s = {"nasta", "jhadu", "pocha", "evening", "dinner", "nahanaP", "nahanaB", "maalish"};
        for (String a : s) {
            System.out.println(a.substring(2) + new StringBuffer(a.substring(0, 2)).reverse());
        }
    }
}
