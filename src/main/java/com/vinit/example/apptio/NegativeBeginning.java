package com.vinit.example.apptio;

import java.util.Arrays;

public class NegativeBeginning {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5,
                6, -7, 5, -3, 11};
        arr= sortNegative(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static int[] sortNegative(int[] arr, int left, int right) {
        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0) {
                left++;
            } else if (arr[left] > 0 && arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (arr[left] > 0 && arr[right] > 0) {
                right--;
            } else if (arr[left] < 0 && arr[right] > 0) {
                left++;
                right--;
            }
        }

        return arr;
    }
}
