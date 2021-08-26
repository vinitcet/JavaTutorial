package com.vinit.example.saplab;

import java.util.Scanner;

public class problemB {

    public static void main(String[] args) {
        boolean possible = true;
        int capacity, noOfStation;
        int member = 0;
        int leave, enter, wait;
        Scanner in = new Scanner(System.in);
        capacity = in.nextInt();
        noOfStation = in.nextInt();
        while (noOfStation > 0) {
            leave = in.nextInt();
            enter = in.nextInt();
            wait = in.nextInt();
            if (!(0 <= leave && leave <= member)) possible = false;
            member -= leave;
            if (!(0 <= enter && enter <= capacity - member)) possible = false;
            member += enter;
            if (0 > wait || (capacity > member && wait > 0)) possible = false;
            noOfStation--;
        }
        System.out.println(possible &&member==0 ? "possible\n" : "impossible\n");
    }
}
