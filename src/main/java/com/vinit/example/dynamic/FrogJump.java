package com.vinit.example.dynamic;

import java.util.HashMap;
import java.util.HashSet;

/*
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone.
The frog can jump on a stone, but it must not jump into the water.
 Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone.
 Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
*/
public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(stones));
        System.out.println(canCross(stones2));
    }

    public static boolean canCross(int[] stones) {
        if (stones.length <= 1) {
            return true;
        }
        if (!(stones[0] == 0 && stones[1] == 1)) {
            return false;
        }
        HashMap<Integer, HashSet<Integer>> dp =
                new HashMap<Integer, HashSet<Integer>>(stones.length);
        for (int i = 0; i < stones.length; i++) {
            dp.put(stones[i], new HashSet<Integer>());
        }
        dp.get(0).add(0);
        for (int i = 0; i < stones.length - 1; ++i) {
            int stone = stones[i];
            for (int step : dp.get(stone)) {
                // step - 1
                if (step > 1 && dp.containsKey(stone + step - 1))
                    dp.get(stone + step - 1).add(step - 1);
                // step
                if (dp.containsKey(stone + step))
                    dp.get(stone + step).add(step);
                // step + 1
                if (dp.containsKey(stone + step + 1))
                    dp.get(stone + step + 1).add(step + 1);
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
