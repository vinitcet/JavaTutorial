package com.vinit.example.sorco;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(checkPalindronme("abcdcba"));
        System.out.println(checkPalindronme("abba"));
        System.out.println(checkPalindronme("abcd"));
        System.out.println(checkPalindronme("pass"));


    }

    static boolean checkPalindronme(String inp) {
        int len = inp.length();
        for (int i = 0; i < len / 2; i++) {
            if (!(inp.charAt(i) == inp.charAt(len - (i+1)))) {
                return false;
            }
        }

        return true;
    }
}
