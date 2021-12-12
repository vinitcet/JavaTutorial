package com.vinit.example.paypal;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/*Given a non-empty array nums containing only positive integers,
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.*/
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int[] num2 = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition(num2));
    }

    public static boolean canPartition(int[] arr) {
        int sum = IntStream.of(arr).sum();
        if (sum % 2 != 0) {
            return false;
        }
        Set<Integer> ms = new TreeSet<>();
        ms.add(0);
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> newSum = new HashSet<>();
            for (int j : ms) {
                newSum.add(j + arr[i]);
            }
            ms.addAll(newSum);
            if (ms.contains(sum / 2)) {
                return true;
            }
        }
        System.out.println(ms);
        return false;
    }
}
