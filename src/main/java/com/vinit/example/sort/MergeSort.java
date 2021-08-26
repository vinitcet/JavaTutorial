package com.vinit.example.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] testArray = {9, 18, 33, -7, 88, 21, 44, 66, 7};
        Arrays.stream(testArray).forEach(System.out::println);
        System.out.println("*********SORTED ARRAY **********");
        Arrays.stream(sort(testArray, 0, testArray.length - 1)).forEach(System.out::println);
    }

    // Main function that sorts arr[first..last] using
    // merge()
    static int[] sort(int arr[], int first, int last) {
        if (first < last) {
            // Find the middle point
            int middle = (first + last) / 2;
            // Sort first and second halves
            sort(arr, first, middle);
            sort(arr, middle + 1, last);
            // Merge the sorted halves
            merge(arr, first, middle, last);
        }
        return arr;
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[first..middle]
    // Second subarray is arr[middle+1..last]
    public static int[] merge(int arr[], int first, int middle, int last) {
        // Find sizes of two subarrays to be merged
        int leftSize = middle - first + 1;
        int rightSize = last - middle;
        /* Create temp arrays */
        int LeftArray[] = new int[leftSize];
        int RightArray[] = new int[rightSize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < leftSize; ++i)
            LeftArray[i] = arr[first + i];
        
        for (int j = 0; j < rightSize; ++j)
            RightArray[j] = arr[middle + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = first;
        while (i < leftSize && j < rightSize) {
            if (LeftArray[i] <= RightArray[j]) {
                arr[k] = LeftArray[i];
                i++;
            } else {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of LeftArray[] if any */
        while (i < leftSize) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of RightArray[] if any */
        while (j < rightSize) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
        return arr;
    }

}
