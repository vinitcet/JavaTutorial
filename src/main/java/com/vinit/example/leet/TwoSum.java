package com.vinit.example.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
        Arrays.stream(twoSum2(nums, target)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return sol;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> imap = IntStream.range(0, nums.length).boxed().collect(Collectors.toMap(i -> nums[i], i -> i));
        for (int i = 0; i < nums.length - 1; i++) {
            if (imap.containsKey(target - nums[i])) {
                return new int[]{i, imap.get(target - nums[i])};
            }
        }
        return null;
    }

    public int[] twoSumFinal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
