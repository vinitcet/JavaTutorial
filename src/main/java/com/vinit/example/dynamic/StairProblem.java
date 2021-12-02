package com.vinit.example.dynamic;

public class StairProblem {

    public static void main(String[] args) {
        long l = System.nanoTime();
        System.out.println("Recursion Approach: " + findWays(18));
        System.out.println("Time Taken:: " + (System.nanoTime() - l));
        long l2 = System.nanoTime();
        System.out.println("Dynamic Approach: " + findWaysDynamic(18));
        System.out.println("Time Taken:: " + (System.nanoTime() - l2));
    }

    static int findWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        return findWays(n - 1) + findWays(n - 2) + findWays(n - 3);
    }

    static int findWaysDynamic(int n) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;
        for (int i = 4; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }
        return ways[n];
    }

}
