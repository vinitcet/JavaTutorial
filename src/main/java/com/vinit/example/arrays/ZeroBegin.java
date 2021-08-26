package com.vinit.example.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class ZeroBegin {
    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 0, 8, 0, 4, 6};
        Deque<Integer> myQueue = new ArrayDeque<>();
        for (int i : a) {
            if (i == 0) {
                myQueue.addFirst(i);
            } else {
                myQueue.addLast(i);
            }

        }
        System.out.println(myQueue);
    }
}
