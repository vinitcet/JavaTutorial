package com.vinit.example.leet;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Arrays.stream(rotate(nums, k)).forEach(System.out::println);
    }

    public static int[] rotate(int[] nums, int k) {
        if (nums == null || k == 0) {
            return nums;
        }

        k = (k % nums.length);

        int[] helper = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            helper[(i + k) % nums.length] = nums[i];
        }
        return helper;
    }
}
