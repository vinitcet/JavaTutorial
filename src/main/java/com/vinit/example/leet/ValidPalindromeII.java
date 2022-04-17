package com.vinit.example.leet;

/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.*/
public class ValidPalindromeII {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // Found a mismatched pair - try both deletions
            if (s.charAt(i) != s.charAt(j)) {
                return (checkPalindrome(s, i, j - 1) || checkPalindrome(s, i + 1, j));
            }

            i++;
            j--;
        }

        return true;
    }

    private static boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static boolean validPalindrome2(String s) {
        int start = 0;
        int end = s.length() - 1;
        int count = 0;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                if (s.charAt(start + 1) == s.charAt(end) && count < 1) {
                    start = start + 2;
                    end--;
                } else if (s.charAt(start) == s.charAt(end--) && count < 1) {
                    start++;
                    end = end = 2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
