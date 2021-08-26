package com.vinit.example.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] testArray = {9, 18, 33, -7, 88, 21, 44, 66, 7};
        Arrays.stream(testArray).forEach(System.out::println);
        System.out.println("*********SORTED ARRAY **********");
        Arrays.stream(insert(testArray)).forEach(System.out::println);
    }

    //1: Iterate from arr[1] to arr[n] over the array.
    //2: Compare the current element (key) to its predecessor.
    //3: If the key element is smaller than its predecessor, compare it to the elements before.
    // Move the greater elements one position up to make space for the swapped element.
    public static int[] insert(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
