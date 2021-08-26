package com.vinit.example.sorco;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StringNumber {

    public static void main(String[] args) {
        System.out.println(new StringNumber().decode("1123"));

    }

    public Set<String> decode(String code) {
        Set<String> result = new TreeSet<String>();
        helper("", code, result);
        return result;
    }


    public void helper(String prefix, String code, Set<String> result) {

        int len = code.length();
        if (len == 0) {
            result.add(prefix);
            return;
        }
        if (code.charAt(0) == '0')
            return;

        helper(prefix + (char) (code.charAt(0) - '1' + 'a'), code.substring(1), result);

        if (len >= 2) {
            int value = Integer.parseInt(code.substring(0, 2));
            if (value <= 26)
                helper(prefix + (char) (value - 1 + 'a'), code.substring(2), result);
        }
    }
}
