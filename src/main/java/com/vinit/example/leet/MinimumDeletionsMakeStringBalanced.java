package com.vinit.example.leet;
/*
You are given a string s consisting only of characters 'a' and 'b'​​​​.
you can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j)
such that i < j and s[i] = 'b' and s[j]= 'a'.
Return the minimum number of deletions needed to make s balanced.*/


public class MinimumDeletionsMakeStringBalanced {

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }

    public static int minimumDeletions(String s) {
        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a = a + 1;
            } else {
                b = Math.max(b + 1, a + 1);

            }
            System.out.println("a ki value: " + a + " b ki value: " + b);
        }
        return s.length() - Math.max(a, b);
    }
}
