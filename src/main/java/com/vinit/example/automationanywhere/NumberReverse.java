package com.vinit.example.automationanywhere;

public class NumberReverse {
    public static void main(String[] args) {
        int i = 12345789;
        int b = 0;
        while (i > 0) {
            b = b * 10 + i % 10;
            i = i / 10;
        }
        System.out.println(b);
    }
}
