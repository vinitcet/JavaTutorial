package com.vinit.example.microsoft;

import java.util.Set;
import java.util.stream.Stream;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String s = "geekForGeeKs";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(s.charAt(i));
            if (sb.indexOf(String.valueOf(s.charAt(i)).toLowerCase()) < 0) {
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
            }

        }
        System.out.println(sb);
    }
}
