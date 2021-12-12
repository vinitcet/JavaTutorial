package com.vinit.example.arrays;

import java.util.Arrays;

public class Array {
    /*    Given an array, rotate the array to the right by k steps, where k is non-negative.*/
    public static void rotate(int[] nums, int k) {
        if (k < 1) {
            return;
        } else if (k > nums.length) {
            k = k % nums.length;
        }
        if (nums == null || nums.length < 1) {
            return;
        }
        int[] helper = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            helper[(i + k) % nums.length] = nums[i];
        }
        nums = helper;
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::print);
    }
}
