package com.vinit.example.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllStringAnagram {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        findAnagrams(s, p).stream().forEach(System.out::println);

    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> ol = new ArrayList<>();
        char[] str = p.toCharArray();
        Arrays.sort(str);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] inp = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(inp);
            if (Arrays.equals(inp, str)) {
                ol.add(i);
            }
        }
        return ol;
    }
}
