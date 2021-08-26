package com.vinit.example.morganstanley;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] arr = {3, 2, 9, 5, 7, 1, 0, 6};
        Arrays.stream(arr).forEach(System.out::println);
        arr = sort(arr);
        System.out.println("**Sorted Element**");
        Arrays.stream(arr).forEach(System.out::println);
    }

    static int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i = -1;
            }
        }
        return arr;
    }
}