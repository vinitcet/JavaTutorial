package com.vinit.example.paypal;

import java.util.Arrays;

/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        Note that you must do this in-place without making a copy of the array.*/
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        int lastloc = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (nums[i] != 0) {
                nums[lastloc++] = nums[i];
            }
        }
        for (int j = size - 1; j > size-1 - count; j--) {
            nums[j] = 0;
        }
        Arrays.stream(nums).forEach(System.out::print);
    }
}
