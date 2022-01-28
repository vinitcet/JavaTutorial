package com.vinit.example.leet;

public class MaximumXOR {

    public static void main(String[] args) {
        //int[] nums = {3, 10, 5, 25, 2, 8};
        int[] nums = {8, 10, 2};
        System.out.println(findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, Integer.parseInt(Integer.toBinaryString(nums[i - 1] ^ nums[i]), 2));
            System.out.println(max);
        }
        return max;
    }
}
