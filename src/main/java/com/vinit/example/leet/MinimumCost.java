package com.vinit.example.leet;

import java.util.Arrays;
import java.util.Collections;

public class MinimumCost {
    public static void main(String[] args) {
        int[] cost = {6, 5, 7, 9, 2, 2};
        System.out.println(minimumCost(cost));
    }

    public static int minimumCost(int[] cost) {
        if (null == cost || cost.length < 1) {
            return 0;
        }
        if (cost.length < 3) {
            return Arrays.stream(cost).sum();
        }
        Integer[] intArr = Arrays.stream(cost).boxed().toArray(Integer[]::new);
        int result = 0;
        int count = 1;
        Arrays.sort(intArr, Collections.reverseOrder());
        for (int i = 0; i < intArr.length; i++) {
            if (!(count++ % 3 == 0)) {
                result += intArr[i];
            }
        }
        return result;
    }
}
