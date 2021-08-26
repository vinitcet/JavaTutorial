package com.vinit.example.sorco;

import java.util.*;

public class RepeatingCharacer {

    public static void main(String[] args) {
        System.out.println(repeatingCharacer("morocco"));
        System.out.println(repeatingCharacer("soroco"));
    }

    public static String repeatingCharacer(String str) {
        Set<Character> setChar = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            setChar.add(c);
        }
        StringBuffer sb = new StringBuffer();
        for (Character c : setChar) {
            sb.append(c.toString());
        }
        return sb.toString();
    }
    public static String repeatingCharacer2(String str) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(!(sb.indexOf(String.valueOf(str.charAt(i)))>=0)){
                sb.append(String.valueOf(str.charAt(i)));
            }
        }
        return sb.toString();
    }
}
