package com.vinit.example.leet;

/*You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat,
and seats[i] = 0 represents that the ith seat is empty (0-indexed).
There is at least one empty seat, and at least one person sitting.
Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
Return that maximum distance to the closest person.*/
public class MaximumDistance {

    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int maxleft = 0;
        int maxright = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                left = 0;
            } else {
                left = left + 1;
            }
            maxleft = Math.max(left, maxleft);
            for (int j = i + 1; j < seats.length; j++) {
                if (seats[j] == 1) {
                    right = 0;
                    break;
                } else {
                    right++;
                    maxright = Math.max(right, maxright);

                }
            }
        }
        return Math.max(left, right);
    }
}
