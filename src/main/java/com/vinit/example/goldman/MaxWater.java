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

    static int findWater(int arr[], int n)
    {
        // initialize output
        int result = 0;
        // maximum element on left and right
        int left_max = 0, right_max = 0;
        // indices to traverse the array
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)
                    // update max in left
                    left_max = arr[lo];
                else
                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }
}
