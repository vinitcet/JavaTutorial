package com.vinit.example.paypal;

public class AllSubstring {
    public static void main(String[] args) {
        String a = "vinit";
        //possibleSubstring(a);
        permute(a, "");
    }

    static void possibleSubstring(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    static void permute(String s, String a) {
        if (s.length() == 0) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String ls = s.substring(0, i);
            String rs = s.substring(i + 1);
            String res = ls + rs;
            permute(res, a + c);
        }

    }

}
