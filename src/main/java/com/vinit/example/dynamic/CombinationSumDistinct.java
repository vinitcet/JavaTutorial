package com.vinit.example.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumDistinct {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates.length == 0) {
            return results;
        }
        //Removing duplicates and sorting
        //int[] candidatesNew = Arrays.stream(candidates).distinct().sorted().toArray(); --slower
        int[] candidatesNew = removeDuplicates(candidates);
        // dfs
        dfs(candidatesNew, 0, new ArrayList<Integer>(), target, results);
        return results;
    }

    private static int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }
        int[] candidatesNew = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            candidatesNew[i] = candidates[i];
        }
        return candidatesNew;
    }

    private static void dfs(int[] candidatesNew, int index, List<Integer> current, int remainTarget, List<List<Integer>> results) {
        if (remainTarget == 0) {
            results.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = index; i < candidatesNew.length; i++) {
            if (remainTarget < candidatesNew[i]) {
                break;
            }
            current.add(candidatesNew[i]);
            dfs(candidatesNew, i, current, remainTarget - candidatesNew[i], results);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 8, 6, 2, 4, 6, 8};
        int sum = 8;
        List<List<Integer>> ans = combinationSum(arr, sum);
        // If result is empty, then
        if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }
        // print all combinations stored in ans
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print(") ");
        }
    }
}
