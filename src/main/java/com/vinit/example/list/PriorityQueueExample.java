package com.vinit.example.list;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        String s = "vinitkumarismynamexzw";
        check(s);
    }

    public static void check(String s) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (Character si : s.toCharArray()) {
            if (pq.size() > 5 && pq.peek().compareTo(String.valueOf(si)) < 0) {
                pq.poll();
                pq.add(String.valueOf(si));
            } else if (pq.size() > 5 && pq.peek().compareTo(String.valueOf(si)) > 0) {

            } else {
                pq.add(String.valueOf(si));
            }
            System.out.println(pq);
        }
        PriorityQueue<String> pq2 = new PriorityQueue<>(5);
        for (Character ch : s.toCharArray()) {
            pq2.add(String.valueOf(ch));
        }
        System.out.println("New Data " + pq2);


    }
}
