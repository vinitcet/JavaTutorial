package com.vinit.example.dynamic;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int op = cost.length;
        int[] dp = new int[op];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < op; i++) {
            dp[i] = (Math.min(dp[i - 1], dp[i - 2]) + cost[i]);
        }
        return Math.min(dp[op - 1], dp[op - 2]);
    }
}
