package com.vinit.example.amazon;

import java.util.*;

public class MinimumCostConnectSticks {
    public static void main(String[] args) {
        int[] a = {1, 8, 3, 5};
        List ls = new ArrayList();
        ls.add(1);
        ls.add(8);
        ls.add(3);
        ls.add(5);
        System.out.println(MinimumCost(ls));
        System.out.println(MinimumCost2(ls));
    }

    public static int MinimumCost(List<Integer> sticks) {
        Collections.sort(sticks);
        int[] dp = new int[sticks.size() + 1];
        dp[1] = sticks.get(0) + sticks.get(1);
        for (int i = 2; i < sticks.size(); i++) {
            dp[i] = dp[i - 1] + sticks.get(i);
        }
        return Arrays.stream(dp).sum();
    }

    public static int MinimumCost2(List<Integer> sticks) {
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(sticks);
        int cost;
        while (queue.size() >= 2) {
            System.out.println(queue);
            cost = queue.poll() + queue.poll();
            ans += cost;
            queue.add(cost);
        }
        return ans;
    }
}
