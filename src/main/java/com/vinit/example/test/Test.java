package com.vinit.example.test;

public class Test {


    public static int resolve(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int result = 0;
        int count = arr.length;
        int min[] = new int[count];
        int max[] = new int[count];
        int m = Integer.MAX_VALUE;
        int ma = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            min[i] = Math.min(m, arr[i]);
            m = min[i];
            max[count - 1 - i] = Math.max(ma, arr[count - 1 - i]);
            ma = max[count - 1 - i];
        }
        for (int i = 0; i < count - 1; i++) {
            result = Math.max(result, max[i + 1] - min[i]);
        }
        return Math.max(0, result);
    }

    public static void main(String[] args) {
        int price[] = {7, 1, 5, 3, 6, 4};
        System.out.println(resolve(price));
        Object oc = new Object();
    }
}