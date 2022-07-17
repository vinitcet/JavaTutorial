package com.vinit.example.test;

public class Sample {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0,
                1, 3, 2, 1, 2, 1};
        maxWater(arr);
    }

    static void maxWater(int[] arr) {
        int len = arr.length;
        int result = 0;
        for (int i = 1; i < len - 1; i++) {
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            int right = arr[i];
            for (int j = i + 1; j < len; j++) {
                right = Math.max(right, arr[j]);
            }
            result += (Math.min(left, right) - arr[i]);
        }
        System.out.println(result);
    }

    public static int trap(int[] arr) {
        int n = arr.length;
        int result = 0;
        int maxLeft = 0, maxRight = 0;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > maxLeft) {
                    maxLeft = arr[lo];
                } else {
                    result += maxLeft - arr[lo];
                }
                lo++;
            } else {
                if (arr[hi] > maxRight) {
                    maxRight = arr[hi];
                } else {
                    result += maxRight - arr[hi];
                }
                hi--;
            }
        }
        return result;
    }

}
