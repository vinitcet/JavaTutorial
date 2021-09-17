package com.vinit.example.blackrock;

public class StringReverse {

    public static void main(String[] args) {
        System.out.println(reverse("Vinit"));
    }


    public static String reverse(String s) {
        if (s.isEmpty()) {
            return s;
        } else {
            return s.substring(1) + s.charAt(0);
        }
    }
}
