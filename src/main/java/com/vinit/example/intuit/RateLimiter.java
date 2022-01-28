package com.vinit.example.intuit;

import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {
    public static void main(String[] args) {

        System.out.println(isRatelimited(1, "login", "3/m", true));
        System.out.println(isRatelimited(11, "login", "3/m", true));
        System.out.println(isRatelimited(21, "login", "3/m", true));
        System.out.println(isRatelimited(30, "login", "3/m", true));
        System.out.println(isRatelimited(65, "login", "3/m", true));
        System.out.println(isRatelimited(300, "login", "3/m", true));

    }

    ///rate =[s/m/h/d]
    private static Queue<Integer> myqueue = new LinkedList<>();
//sliding window
    public static boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        if (!event.equalsIgnoreCase("login") || !increment) {
            return false;
        }
        String aRate = rate.substring(rate.indexOf("/"));
        int internalRate = 0;
        if (aRate.equalsIgnoreCase("s") || aRate.equalsIgnoreCase("m")) {
            internalRate = 60;
        } else if (aRate.equalsIgnoreCase("h")) {
            internalRate = 24;
        } else {
            internalRate = 30;
        }
        if (myqueue.size() >= Integer.valueOf(rate.substring(0, rate.indexOf("/")))) {
            if (timestamp - myqueue.peek() > internalRate) {
                myqueue.poll();
                myqueue.add(timestamp);
            } else {
                //ignoring the event
                return true;
            }
        } else {
            myqueue.add(timestamp);
        }
        return false;
    }
}
