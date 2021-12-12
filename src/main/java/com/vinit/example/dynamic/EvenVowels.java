package com.vinit.example.dynamic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EvenVowels {

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        // evenVowels(s);
        System.out.println(findTheLongestSubstring(s));
    }

    public static void evenVowels(String s) {
        Map<String, Map<String, Integer>> myMap = new LinkedHashMap<>();
        int count = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        String max = "";
        for (int i = 0; i < count; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (!countMap.containsKey(String.valueOf(ch))) {
                    countMap.put(String.valueOf(ch), 1);
                } else {
                    countMap.put(String.valueOf(ch), countMap.get(String.valueOf(ch)) + 1);
                    if (!(countMap.containsValue(1))) {
                        max = s.substring(0, i + 1);
                    }
                }
            }
            myMap.put(s.substring(count - i - 1), new HashMap<>(countMap));
        }
        System.out.println(max);
        System.out.println(myMap);
    }

    public static int findTheLongestSubstring(String s) {
        int res = 0, mask = 0, n = s.length();
        Map<Integer, Integer> maskToIndex = new HashMap();
        maskToIndex.put(0, -1);
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            /*System.out.println(c);
            System.out.println("aeiou".indexOf(c) + " : " + ("aeiou".indexOf(c) + 1));
            System.out.println(1 << ("aeiou".indexOf(c) + 1));
            System.out.println(1 << ("aeiou".indexOf(c) + 1) >> 1);*/
            mask ^= 1 << ("aeiou".indexOf(c) + 1) >> 1;
           // System.out.println(mask);
            maskToIndex.putIfAbsent(mask, j);
            res = Math.max(res, j - maskToIndex.get(mask));
        }
        System.out.println(maskToIndex);
        return res;
    }
}
