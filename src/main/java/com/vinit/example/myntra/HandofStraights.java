package com.vinit.example.myntra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class HandofStraights {
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(isNStraightHand2(hand, groupSize));
        StringBuilder  a=new StringBuilder("vinit");
       a.reverse();
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> ls = new LinkedList<Integer>(Arrays.asList(IntStream.of(hand)
                .boxed()
                .toArray(Integer[]::new)));
        pq.addAll(ls);
        for (int i = 0; i < hand.length / groupSize; i++) {
            int j = pq.poll();
            ls.remove(ls.indexOf(j));
            for (int k = 0; k < groupSize - 1; k++) {
                int r = j + k + 1;
                if (!ls.contains(r)) {
                    return false;
                } else {
                    pq.remove(r);
                    ls.remove(ls.indexOf(r));
                }
            }
        }
        return true;
    }

    public static boolean isNStraightHand2(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(IntStream.of(hand)
                .boxed()
                .toArray(Integer[]::new)));
        for (int i = 0; i < hand.length / groupSize; i++) {
            int j = pq.poll();
            for (int k = 1; k < groupSize; k++) {
                int r = j + k;
                if (!pq.contains(r)) {
                    return false;
                } else {
                    pq.remove(r);
                }
            }
        }
        return true;
    }
}
