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
        //System.out.println(canPartition(num2));
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
            System.out.println(ms);
            if (ms.contains(sum / 2)) {
                return true;
            }
        }
        System.out.println(ms);
        return false;
    }

    public boolean canPartitionFaster0(int[] arr) {

        int n = arr.length;
        int sum = 0;
        int i, j;

        // Calculate sum of all elements
        for(i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        boolean[] part = new boolean[sum / 2 + 1];

        // Initialize the part array
        // as 0
        for(i = 0; i <= sum / 2; i++)
        {
            part[i] = false;
        }

        // Fill the partition table in
        // bottom up manner
        for(i = 0; i < n; i++)
        {

            // The element to be included
            // in the sum cannot be
            // greater than the sum
            for(j = sum / 2; j >= arr[i]; j--)
            {

                // Check if sum - arr[i] could be
                // formed from a subset using elements
                // before index i
                if (part[j - arr[i]] == true || j == arr[i])
                    part[j] = true;
            }
        }
        return part[sum / 2];

    }
}
