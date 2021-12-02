package com.vinit.example.dynamic;

public class RobHouse {
    public static void main(String[] args) {
        int val[] = {6, 7, 1, 3, 8, 2, 4};
        //int val[] = {2, 1, 1, 2};
        System.out.println(robMax(val));
        System.out.println(robMaxDP(val));
        System.out.println(robMaxDP2(val));

    }

    static int robMax(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                even += arr[i];
            } else {
                odd += arr[i];
            }
        }
        return Math.max(even, odd);
    }

    static int robMaxDP(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 1;
        dp[1] = arr[1];
        dp[2] = Math.max(arr[1], arr[2]);
        dp[3] = Math.max(arr[3] + dp[1], dp[2]);
        for (int i = 4; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }
        //Arrays.stream(dp).forEach(System.out::println);
        return dp[arr.length - 1];
    }

    static long robMaxDP2(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        long[][] dp = new long[n][2];
        dp[0][0] = 0;
        dp[0][1] = A[0];
        for (int i = 1; i < n; i++) {
            // If you don't grab the i-th one, take the first i-1 position dp greater value
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // If you grab the i-th one and don’t grab the previous one, consider the transfer of the dp value from the first i-2 positions
            dp[i][1] = A[i] + dp[i - 1][0];
        }
        long result = Math.max(dp[n - 1][0], dp[n - 1][1]);
        return result;
    }
}
