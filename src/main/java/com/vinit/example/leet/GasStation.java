package com.vinit.example.leet;

import java.util.ArrayList;
import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        Integer[] gas = {1, 2, 3, 4, 5};
        Integer[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(Integer[] gas, Integer[] cost) {
        ArrayList<Integer> gasList = new ArrayList(Arrays.asList(gas));
        gasList.addAll(new ArrayList(Arrays.asList(gas)));
        ArrayList<Integer> costList = new ArrayList(Arrays.asList(cost));
        costList.addAll(new ArrayList(Arrays.asList(cost)));
        int i;
        a:
        for (i = 0; i < gas.length; i++) {
            int count = 0;
            int getGas = i;
            int gasRequired = 0;
            int pos = i;
            System.out.println("Staring from : " + pos + " with gas : " + gasList.get(pos));
            while (count++ < gas.length) {
                gasRequired = (int) gasList.get(++pos);
                //able to reach
                if (getGas - gasRequired > 0) {
                    getGas += pos;
                    //pos++;
                    if (count + 1 == gas.length) {
                        break a;
                    }
                } else {
                    break;
                }

            }
        }
        return i >= gas.length ? 0 : i;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length != gas.length) return -1;
        int n = gas.length;
        int[] dp = new int[n * 2];
        dp[0] = gas[0] - cost[0];
        int start = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + gas[i % n] - cost[i % n];
            } else {
                if (i - start > n) return start;
                start = i;
                dp[i] = gas[i % n] - cost[i % n];
            }
        }
        if (2 * n - start > n) return start;
        return -1;
    }
}
