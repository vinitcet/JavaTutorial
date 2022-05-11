package com.vinit.example.practice;

public class PalindromeNumber {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        if (x < 0) {
            return false;
        }
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


}
