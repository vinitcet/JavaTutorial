package com.vinit.example.myntra;

import java.util.Arrays;

/*
The sample of the question is to split the tree from the middle, but in fact,
it can be cut from any point as the root node of the tree, and other non-leaf child nodes can also be cut from any point.
We can consider using dp to determine whether s2 is the climbing string of s1.

We use an array dp[n][i][j] to indicate whether the two substrings of s1[i..i+n-1] and s2[j..j+n-1] are scrambled
Initial condition: When the length is 1, if the strings are equal, it will be met, otherwise it will not be met.
When the length is n, put the root node of the tree represented by the string on the 2nd to n-1 elements.
When the subtree on one side is empty, it is meaningless because it is itself. That is, there are n-1 cases for a string of length n, which are 1, k.
 The value of k ranges from 1 to n-1. In the case of n-1, as long as there is one match, it means that the string of length n matches.
In each case, there are two ways, the first k of s1 is compared with the first k of s2, and the n-k after s1 is compared with the last n-k of s2.
 It can also be a comparison between the first k of s1 and the last k of s2.
 The two methods correspond to the scenario where the subtree is not exchanged and exchanged.
We only need to calculate whether s1[i, i+n-1] and s2[j, j+n-1] of length n are scrambled, and whether there is one satisfaction by traversing all substrings,
Transfer equation: dp[n][i][j] = dp[k][i][j] && dp[nk][i+k][j+k] || dp[k][i][j +nk] && dp[nk][i+k][j] (where k is the length of the left substring of the s1 part)
Finally, use dp[n][0][0] to determine whether the entire string is a climbing string

Complexity analysis
Time complexity O(n^3)
n is the length of the string
Space complexity O(n^3)
n is the length of the string
*/

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int size = s1.length();
        if (size != s2.length()) {
            return false;
        }
        // Early pruning of non-character sets equal
        char[] sortS1 = s1.toCharArray();
        Arrays.sort(sortS1);
        char[] sortS2 = s2.toCharArray();
        Arrays.sort(sortS2);
        if (!Arrays.equals(sortS1, sortS2)) {
            return false;
        }
        // dp[n][i][j] indicates whether the two substrings of s1[i..i+n-1] and s2[j..j+n-1] are scrambled
        // The starting point of the iteration, the direct comparison of length 1 calculates the result; the others are initialized to false
        boolean[][][] dp = new boolean[size + 1][size][size];
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (i == 0 || i == 1 && s1.charAt(j) == s2.charAt(k)) {
                        dp[i][j][k] = true;
                    } else {
                        dp[i][j][k] = false;
                    }
                }
            }
        }
        // Calculate the larger length in turn, for the case of length n, directly see whether all substring divisions are satisfied
        // Since n is increasing, the substrings are all already calculated
        for (int n = 2; n < size + 1; n++) {
            for (int i = 0; i <= size - n; i++) {
                for (int j = 0; j <= size - n; j++) {
                    // Calculate whether the length is n, s1[i, i+n-1] and s2[j, j+n-1] are scramble
                    // By traversing all substrings to divide whether there is one satisfaction
                    for (int k = 1; k < n; k++) {// k is the length of the left substring of the s1 part
                        if (dp[k][i][j] && dp[n - k][i + k][j + k]
                                || dp[k][i][j + n - k] && dp[n - k][i + k][j]) {
                            dp[n][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        // The final result is whether s1[0,size] and s2[0,size] match
        return dp[size][0][0];
    }
}
