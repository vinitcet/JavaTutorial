package com.vinit.example.practice;

import com.vinit.example.arrays.Array;

import java.util.Arrays;
import java.util.List;

public class SmallestStringSwap {

    public static void main(String[] args) {

        //String s = "cba";
        //List<List<Integer>> pairs = List.of(List.of(0, 1), List.of(1, 2));
        String s = "dcab";
        List<List<Integer>> pairs = List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2));
        System.out.println(smallestStringWithSwaps(s, pairs));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int count = 0;
        while (!isAlphabaticOrder(s)) {
            if (count > pairs.size()) {
                break;
            }
            for (int i = 0; i < pairs.size(); i++) {
                char[] c = s.toCharArray();
                if (c[pairs.get(i).get(0)] > c[pairs.get(i).get(1)]) {
                    char temp = c[pairs.get(i).get(0)];
                    c[pairs.get(i).get(0)] = c[pairs.get(i).get(1)];
                    c[pairs.get(i).get(1)] = temp;
                    s = String.valueOf(c);
                    count++;
                }

                if (i == pairs.size() - 1 && count == 0) {
                    count = pairs.size() + 2;
                }
                if (i == pairs.size() - 1 && count != 0 && count < pairs.size() + 1) {
                    count = 0;
                }
            }

        }
        return s;
    }

    public static boolean isAlphabaticOrder(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
