package com.vinit.example.amazon;

import java.util.HashSet;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null && t == null | s.equalsIgnoreCase(t)) {
            return true;
        }
        if (s != null && t == null || s == null && t != null || s.length() != t.length()) {
            return false;
        }
        String op = s;
        Set<Character> c = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!c.contains(s.charAt(i))) {
                c.add(s.charAt(i));
                char a = s.charAt(i);
                char b = t.charAt(i);
                if (a != b && op.substring(i).contains(String.valueOf(b))) {
                    return false;
                }
                op = op.replaceAll(String.valueOf(a), String.valueOf(b));
            }

        }
        System.out.println(s + " " + t + " " + op);
        return op.equals(t);
    }
}
