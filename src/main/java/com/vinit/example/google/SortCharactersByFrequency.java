package com.vinit.example.google;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "bbcccaaadd";
        System.out.println(frequencySort(s));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int nn = Math.abs(n);
        Double ans = 1.0;
        while (nn > 0) {
            ans *= x;
            nn--;
        }
        return n > 0 ? ans : 1 / ans;
    }

    public static String frequencySort(String s) {
        if (s.length() < 2) {
            return s;
        }
        Map<String, Long> map = s.chars().mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> result2 = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        StringBuilder result = new StringBuilder();
        for (Map.Entry entry : result2.entrySet()) {
            for (long i = 0; i < (long) entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }

    public String frequencySort2(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            if (count[i] > 0) {
                list.add((char) i);
            }
        }

        Collections.sort(list, (a, b) -> {
            int t = count[b] - count[a];
            if (t == 0) {
                return a - b;
            }
            return t;
        });

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            for (int i = 0; i < count[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
