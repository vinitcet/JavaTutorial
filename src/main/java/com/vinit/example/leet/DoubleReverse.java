package com.vinit.example.leet;

public class DoubleReverse {
    public static void main(String[] args) {
        int num = 526;
        System.out.println(isSameAfterReversals(num));
    }

    public static boolean isSameAfterReversals(int num) {
        System.out.println(Integer.valueOf(new StringBuilder(num + "").reverse().toString()));
        return num == Integer.valueOf(new StringBuilder(
                Integer.valueOf(new StringBuilder(num + "").reverse().toString()) + "").reverse().toString());
    }
}
