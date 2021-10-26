package com.vinit.example.opentext;

public class Test2 {
    public static void main(String[] args) {
        System.out.println((solution("aaaa", new int[]{3, 4, 5, 6})));
    }

    public static int solution(String S, int[] C) {
        //Checking size for string and array
        if (S.length() < 0 || S.length() > 100000 || C.length < 0 || C.length > 10000) {
            return 0;
        }
        //Checking for uppercase
        for (int i = 0; i < S.length(); i++) {
            if (Character.isUpperCase(S.charAt(i))) {
                return 0;
            }
        }
        //Checking element in C
        for (int i = 0; i < C.length; i++) {
            if (C[i] < 0 || C[i] > 1000) {
                return 0;
            }
        }
        int tot = 0;
        int maximum = C[0];
        int ctotal = C[0];
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                tot += ctotal - maximum;
                ctotal = maximum = C[i];
            } else {
                ctotal += C[i];
                maximum = Math.max(maximum, C[i]);
            }
        }
        tot += ctotal - maximum;
        return tot;
    }
}
