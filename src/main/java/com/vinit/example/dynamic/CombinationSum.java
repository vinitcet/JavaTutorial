package com.vinit.example.dynamic;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen
// numbers sum to target. You may return the combinations in any order.
//        The same number may be chosen from candidates an unlimited number of times.
//        Two combinations are unique if the frequency of at least one of the chosen numbers is different.
public class CombinationSum {

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8};
        int x = 8;
        System.out.println(combinationSum4(arr, x));
    }

    static int combinationSum4(int[] nums, int target) {
        int[] sum = new int[target + 1];
        sum[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    sum[i] += sum[i - num];
                }
            }
        }
        for(int s: sum){
            System.out.print(s+" ");
        }
        System.out.println();
        return sum[target];
    }

}
