package com.vinit.example.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null && nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    results.add(new ArrayList<>(list));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return results;
    }

    public List<List<Integer>> threeSum(int[] numbers) {
        int n = numbers.length;
        Arrays.sort(numbers);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int first = 0; first < n; ++first) {
            if (first > 0 && numbers[first] == numbers[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = -numbers[first];
            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && numbers[second] == numbers[second - 1]) {
                    continue;
                }
                while (second < third && numbers[second] + numbers[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (numbers[second] + numbers[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[first]);
                    list.add(numbers[second]);
                    list.add(numbers[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
