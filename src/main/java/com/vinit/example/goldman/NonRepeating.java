package com.vinit.example.goldman;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeating {
    public static void main(String[] args) {
        NonRepeating("GeeksForGeeks");
    }

    static void NonRepeating(String str) {

        Map<Character, Long> getMap = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry e : getMap.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }


        Map<Character, Integer> cm = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (cm.containsKey(str.charAt(i))) {
                cm.put(str.charAt(i), (cm.get(str.charAt(i)) + 1));
            } else {
                cm.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry e : cm.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }


    }
}
