package com.vinit.example.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDnaSequences {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        List<String> a = repeated(s);
        a.forEach(System.out::println);

    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set one = new HashSet();
        Set two = new HashSet();
        for (int i = 0; i < s.length() - 9; i++) {
            String tmp = s.substring(i, i + 10);
            if (!one.add(tmp)) {
                two.add(tmp);
            }
        }
        return new ArrayList(two);
    }

    public static List<String> repeated(String s) {
        List<String> op = new ArrayList<>();
        if (s.length() > 100000) {
            return op;
        }
        for (int i = 0; i < s.length() - 11; i++) {
            for (int j = i + i; j < s.length() - 11; j++) {
                if (s.substring(i, i + 10).equals(s.substring(j, j + 10))) {
                    if (!(op.contains(s.substring(i, i + 10))))
                        op.add(s.substring(i, i + 10));
                }
            }
        }

        return op;
    }
}
