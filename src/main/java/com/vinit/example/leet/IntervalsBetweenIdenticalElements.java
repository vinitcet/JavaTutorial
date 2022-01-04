package com.vinit.example.leet;

import java.util.Arrays;

public class IntervalsBetweenIdenticalElements {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 1, 2, 3, 3};
        getDistances(arr);

    }

    public static long[] getDistances(int[] arr) {
        int size = arr.length;
        long op[] = new long[size];
        int[] full = Arrays.copyOf(arr, size * 2);
        for (int i = 0; i < size; i++) {
            full[i + size] = arr[i];
        }
        for (int i = 0; i < size; i++) {
            int j = i + 1;
            while (j < i + size) {
                if (full[j] == full[i]) {
                    if (j >= size) {
                        op[i] += Math.abs(i - (j - size));
                    } else {
                        op[i] += Math.abs(i - j);
                    }
                }
                j++;
            }
        }
        return op;
    }

    public static long[] getDistances2(int[] arr) {
        int n = arr.length, M = 100001;
        long[] ans = new long[n];
        long[] forSum = new long[M], backSum = new long[M];
        int[] forCnt = new int[M], backCnt = new int[M];
        for (int i = 0; i < n; i++) {
            forSum[arr[i]] += i; //get the sum
            forCnt[arr[i]]++; //track its count
        }

        for (int i = 0; i < n; i++) {
            long forward = forSum[arr[i]] - (long) i * forCnt[arr[i]]; //forward portion of it (upper right triangle area)
            long backward = (long) i * backCnt[arr[i]] - backSum[arr[i]]; //backward portion of it (lower left triangle area)
            ans[i] = forward + backward; //both area combined is our ans
            backSum[arr[i]] += i; //move current idx to backSum
            forSum[arr[i]] -= i; //and subtract it from forSum
            forCnt[arr[i]]--; //do the same here
            backCnt[arr[i]]++; //and here
        }

        return ans;
    }
}
