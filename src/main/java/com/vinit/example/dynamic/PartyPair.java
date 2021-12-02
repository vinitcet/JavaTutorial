package com.vinit.example.dynamic;
//Given that there are p people in a party.Each person can either join dance as a single individual or as a pair with any other.
// The task is to find the number of different ways in which p people can join the dance.

public class PartyPair {

    public static void main(String[] args) {
        System.out.println(partyPairDP(3));
    }

    static int partyPairDP(int n) {
        if (n == 0) {
            return 0;
        }
        ;

        int[] sol = new int[n + 1];
        sol[0] = 0;
        sol[1] = 1;
        sol[2] = 2;
        for (int i = 3; i <=n; i++) {
            sol[i] = sol[i - 1] + sol[i - 2] * (i - 1);
        }
        return sol[n];
    }
}