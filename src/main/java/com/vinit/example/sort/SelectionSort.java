package com.vinit.example.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] testArray = {9, 18, 33, -7, 88, 21, 44, 66, 7};
        Arrays.stream(testArray).forEach(System.out::println);
        System.out.println("*********SORTED ARRAY **********");
        Arrays.stream(select(testArray)).forEach(System.out::println);
    }

    public static int[] select(int[] arr) {
        int n = arr.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
