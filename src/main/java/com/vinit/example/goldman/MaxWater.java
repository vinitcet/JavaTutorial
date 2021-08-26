package com.vinit.example.goldman;
/*CoderPad*/
public class MaxWater {
    static int getMax(int[] a, int size) {
        int res = 0;

        for (int i = 1; i < size - 1; i++) {
            // max in left
            int left = a[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, a[j]);
            }
            //max in right
            int right = a[i];
            for (int j = i + 1; j < size; j++) {
                right = Math.max(right, a[j]);
            }

            res += (Math.min(left, right) - a[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0,
                1, 3, 2, 1, 2, 1};
        int n = arr.length;

        System.out.print(getMax(arr, n));
    }
}
