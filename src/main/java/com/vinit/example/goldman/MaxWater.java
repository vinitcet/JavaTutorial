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

        System.out.println(getMax(arr, n));
        System.out.println(findWater(arr));
    }

    static int findWater(int arr[], int n) {
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
            } else {
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

    static int findWater(int arr[]) {
        if(arr.length<3){
            return 0;
        }
        int size = arr.length;
        int left[] = new int[size];
        left[0] = arr[0];
        int right[] = new int[size];
        right[size - 1] = arr[size - 1];
        int ans = 0;
        for (int i = 1; i < size - 1; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        for (int i = size - 2; i > 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left[i], right[i]) - arr[i];
        }
        return ans;
    }
}
