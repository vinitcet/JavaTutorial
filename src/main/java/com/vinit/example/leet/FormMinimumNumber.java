package com.vinit.example.leet;

/*
Given a pattern str containing only I and D. I for increasing and D for decreasing.
Please design an algorithm to return the string that conforms to the pattern and has the smallest dictionary order.
Digits from 1 to 9 and digits can’t repeat.
*/

public class FormMinimumNumber {
    public static void main(String[] args) {
        String s = "DIDID";
        System.out.println(formMinimumNumber(s));
    }

    public static String formMinimumNumber(String str) {
        StringBuilder sb = new StringBuilder();
        str = "#" + str;
        int pos = 0, val = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'I') {
                pos = sb.length();
            }
            sb.insert(pos, val++);
        }
        return sb.toString();
    }

}
