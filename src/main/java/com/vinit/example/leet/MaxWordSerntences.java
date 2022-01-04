package com.vinit.example.leet;

public class MaxWordSerntences {
    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println();
    }

    public static int mostWordsFound(String[] sentences) {
        int count = 0;
        for (String s : sentences) {
            count = Math.max(s.split(" ").length, count);
        }
        return count;
    }
}
