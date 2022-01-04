package com.vinit.example.leet;

public class TimeBuyTickets {

    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));

    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        int kval = tickets[k];
        while (kval > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    count++;
                    tickets[i] = tickets[i] - 1;
                }
                if (i == k) {
                    kval = tickets[i];
                    if (kval == 0) {
                        break;
                    }
                }
            }
        }
        return count;
    }

}
