package com.vinit.example.myntra;

import java.util.TreeSet;

/*Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements
without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].*/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18, 19, 20, 21, 22};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums2));
        System.out.println(lengthOfLIStheir(nums2));
    }


    public static int lengthOfLIStheir(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i : nums) {
            Integer ceil = set.ceiling(i);
            if (ceil != null) {
                set.remove(ceil);
            }
            set.add(i);
        }
        return set.size();
    }

    public static int lengthOfLIS(int[] nums) {
        int sz = nums.length;
        int[] dp = new int[sz];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < sz; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
