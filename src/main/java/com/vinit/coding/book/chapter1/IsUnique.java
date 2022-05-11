package com.vinit.coding.book.chapter1;

public class IsUnique {

    /*    Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
        cannot use additional data structures?*/
    public static void main(String[] args) {
        System.out.println(isUnique("abcABCDa"));

    }

    public static boolean isUnique(String s) {
        if (s.length() > 26) {
            return false;
        }
        boolean[] ar = new boolean[128];
        for (char c : s.toCharArray()) {
            if (ar[c]) {
                return false;
            } else {
                ar[c] = true;
            }
        }
        return true;
    }
}
