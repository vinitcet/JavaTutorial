package com.vinit.example.morganstanley;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class permutationalindrome {
    public static void main(String[] args) {
        checkPalindrome("baba");
    }

    static boolean checkPalindrome(String s) {
        List<Character> gl = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Map<Character, Long> getMap = gl.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int count = 0;
        for (Long i : getMap.values()) {
            if (i % 2 > 0) {
                count++;
                if (count > 1) {
                    System.out.println("Not a palindrome");
                    return false;
                }
            }
        }
        System.out.println("palindrome");

        return false;
    }
}
