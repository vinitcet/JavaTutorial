package com.vinit.example.morganstanley;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] testArray = {9, 18, 33, -7, 88, 21, 44, 66, 7};
        Arrays.stream(testArray).forEach(System.out::println);
        System.out.println("*********SORTED ARRAY **********");
        Arrays.stream(sort(testArray, 0, testArray.length - 1)).forEach(System.out::println);
    }

    static int[] sort(int[] a, int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            sort(a, first, middle);
            sort(a, middle + 1, last);
            merge(a, first, middle, last);
        }
        return a;
    }

    static void merge(int[] arr, int first, int middle, int last) {
        int leftSize = middle - first + 1;
        int rightSize = last - middle;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        for (int i = 0; i < leftSize; ++i) {
            leftArr[i] = arr[first + i];
        }
        for (int j = 0; j < rightSize; ++j) {
            rightArr[j] = arr[middle + 1 + j];
        }
        //start merging
        int k = first;
        int i = 0;
        int j = 0;
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}

