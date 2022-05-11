package com.vinit.coding.book.chapter1;

import java.util.ArrayList;
import java.util.List;

/*Given two strings,write a method to decide if one is a permutation of the
        other.*/
public class CheckPermutation {
    public static void main(String[] args) {
        String a = "abc";
        String c = "cba";
        //getPermutation(a, "");
        List<String> sl = checkIfPermutation(a, "", new ArrayList<>());
        sl.stream().forEach(System.out::println);
        System.out.println(sl.contains(c));
    }

    public static void getPermutation(String str, String res) {
        if (str.length() == 0) {
            System.out.println(res);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            getPermutation(ros, res + ch);
        }
    }

    public static List checkIfPermutation(String str, String res, List<String> sList) {
        if (str.length() == 0) {
            // System.out.println(res);
            sList.add(res);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            checkIfPermutation(ros, res + ch, sList);
        }
        return sList;
    }
}
