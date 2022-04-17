/*
package com.vinit.example.goldman;

import java.util.*;
import java.util.stream.Collectors;

*/
/*CoderPad*//*

public class GroupAnagram {

    public static void main(String[] args) {
        String[] a = {"cat", "dog", "tac", "god", "act"};
        printGroup(a);
    }

    static void printGroup(String[] a) {
        List<String> lst = Arrays.stream(a).map(s -> s.toCharArray()).map(chars -> {
            Arrays.sort(chars);
            return new String(chars);
        })
                .collect(Collectors.toList());
        lst.forEach(System.out::println);
        Map<String, List<Integer>> imap = new LinkedHashMap<>();
        for (int i = 0; i < lst.size(); i++) {
            imap.putIfAbsent(lst.get(i), new ArrayList<>());
            imap.get(lst.get(i)).add(i);
        }
        for (var entry : imap.entrySet()) {
            System.out.println(entry.getValue().stream().map(i -> a[i]).collect(Collectors.toList()));
        }
    }
}
*/
