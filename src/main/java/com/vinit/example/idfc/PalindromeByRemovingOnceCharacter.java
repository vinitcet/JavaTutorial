package com.vinit.example.idfc;

public class PalindromeByRemovingOnceCharacter {
    public static void main(String[] args) {
        String a = "abccba";
        System.out.println(isPalindrome(a, 0, a.length() - 1));
    }

    static boolean isPalindrome(String str, int s, int e) {
        if (s == e) {
            return true;
        }
        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }
        if (s < e) {
            isPalindrome(str, s + 1, e - 1);
        }
        return true;
    }

    static int possibleByRemovingOne(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                //If removing str[low] makes the whole string palindrome.
                if (isPalindrome(s, low + 1, high)) {
                    return low;
                }
                //If removing str[right] makes the whole string palindrome.
                if (isPalindrome(s, low, high - 1)) {
                    return high;
                }
                return -1;
            }

        }

        return -2;

    }
}
