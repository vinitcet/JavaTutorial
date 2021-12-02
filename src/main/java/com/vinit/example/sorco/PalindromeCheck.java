package com.vinit.example.sorco;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(checkPalindronme("abcdcba"));
        System.out.println(checkPalindronme("abba"));
        System.out.println(checkPalindronme("abcd"));
        System.out.println(checkPalindronme("pass"));
        System.out.println("****************");
        System.out.println(checkPalindronme("abcdcba",0,7));
        System.out.println(checkPalindronme("abba",0,4));
        System.out.println(checkPalindronme("abcd",0,4));
        System.out.println(checkPalindronme("pass",0,4));

    }

    static boolean checkPalindronme(String inp) {
        int len = inp.length();
        for (int i = 0; i < len / 2; i++) {
            if (!(inp.charAt(i) == inp.charAt(len - (i + 1)))) {
                return false;
            }
        }
        return true;
    }


    static boolean checkPalindronme(String inp, int l, int r) {
        if (l < r) {
            if (inp.charAt(l) == inp.charAt(r-1)) {
                checkPalindronme(inp, l + 1, r - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
