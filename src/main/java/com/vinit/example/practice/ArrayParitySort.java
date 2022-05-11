package com.vinit.example.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ArrayParitySort {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int[] op = sortArrayByParity(nums);
        Arrays.stream(op).forEach(System.out::println);
    }

    public static int[] sortArrayByParity(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i : nums) {
            if (i % 2 == 0) {
                deque.addFirst(i);
            } else {
                deque.add(i);
            }
        }
        int[] op = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            op[i] = deque.pop();
        }
        return op;
    }

}
