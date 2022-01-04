package com.vinit.example.myntra;
/*You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).*/

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}, {3, 8}};
        int[][] envelopes2 = {{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
        int[][] envelopes3 = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        System.out.println(maxEnvelopes(envelopes3));
        System.out.println(maxEnvelopesTry(envelopes3));
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

    public static int maxEnvelopesTry(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        Arrays.stream(envelopes).forEach(s -> {
                    Arrays.stream(s).forEach(System.out::print);
                    System.out.println();
                }
        );
        int max = 1;
        int dp[] = new int[envelopes.length + 2];
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
