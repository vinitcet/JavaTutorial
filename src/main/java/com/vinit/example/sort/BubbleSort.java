package com.vinit.example.sort;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {
        int[] testArray = {9, 18, 33, -7, 88, 21, 44, 66, 7};
        Arrays.stream(testArray).forEach(System.out::println);
        System.out.println("*********SORTED ARRAY **********");
        Arrays.stream(bubble(testArray)).forEach(System.out::println);
    }

    public static int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] >arr[j]) {
                    int a = arr[i];
                    arr[i] = arr[j];
                    arr[j] = a;
                }
            }
        }
        return arr;
    }

}