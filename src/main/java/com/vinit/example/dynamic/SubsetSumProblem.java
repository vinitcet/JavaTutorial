package com.vinit.example.dynamic;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int set[] = {11};
        int sum = 9;
        System.out.println(canSum(set, set.length, sum));
    }

    public static boolean canSum(int[] set, int n, int sum) {

        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return canSum(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return canSum(set, n - 1, sum)
                || canSum(set, n - 1, sum - set[n - 1]);
    }
}
