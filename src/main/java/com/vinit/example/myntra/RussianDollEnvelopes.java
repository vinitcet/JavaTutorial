package com.vinit.example.myntra;
/*You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).*/

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3},{3,8}};
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        // First, sort the envelopes in ascending order of the first parameter and descending order of the second parameter
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        //Initialize the dp array, cnt represents the length of the dp array
        //Let dp[i]=minwidth indicate that the minimum width of the element at the end of the ascending subsequence of length i is minwidth
        //len indicates the length of the dp array used
        int dp[] = new int[envelopes.length];
        int len = 0;
        for (int i = 0; i < envelopes.length; i++) {
            /*
            1. If a keyword is found, the return value is the position index of the keyword in the array, and the index starts from 0
            2. If the keyword is not found, the return value is a negative insertion point value,
            The so-called insertion point value is the position index of the first element larger than the key in the array
            And this position index starts from 1.
            */
            int index = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
            if (index < 0) {
                index = -index - 1;
            }
            dp[index] = envelopes[i][1];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
