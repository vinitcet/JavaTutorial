package com.vinit.example.leet;

import java.util.*;
import java.util.stream.Collectors;

public class LastStoneWeight {
    public static void main(String[] args) {
        int stones[] = {2, 7, 4, 1, 8, 1};
        //int stones[] = {3, 1};
        System.out.println(lastStoneWeight(stones));

    }

    public static int lastStoneWeight(int[] stones) {
        List<Integer> sl = Arrays.stream(stones).boxed().collect(Collectors.toList());
        while (sl.size() > 1) {
            Collections.sort(sl, Collections.reverseOrder());
            int a = sl.get(0);
            int b = sl.get(1);
            if (a != b) {
                sl.add(a - b);
            }
            sl.remove(0);
            if (sl.size() > 1) {
                sl.remove(0);
            }
        }
        return sl.get(0);
    }

    public int lastStoneWeight2(int[] stones) {
        List<Integer> sl = Arrays.stream(stones).boxed().collect(Collectors.toList());
        Queue<Integer> stonesQueue = new PriorityQueue<>(Collections.reverseOrder());
        int tempStone = 0, result = 0;

        for (int stone : stones) {
            stonesQueue.add(stone);
        }

        while (stonesQueue.size() > 1) {
            tempStone = stonesQueue.poll() - stonesQueue.poll();
            stonesQueue.add(tempStone);
        }

        return stonesQueue.peek();

    }
}
