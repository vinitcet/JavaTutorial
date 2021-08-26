package com.vinit.example.goldman;

/* Java program to find the number of ways to reach a given score in a game */

import java.util.Scanner;

public class problem11 {

    static int count_number_of_ways(int n, int points[], int tot) {

        int[] arr = new int[n + 1];

        int i, j;

        for (j = 0; j < n + 1; j++)

            arr[j] = 0;


        arr[0] = 1;

        while (tot > 0) {

            for (i = points[tot]; i <= n; i++)

                arr[i] += arr[i - points[tot]];

        }


        return arr[n];

    }

    public static void main(String[] args) {

        int n, tot;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the score : ");

        n = sc.nextInt();

        System.out.print("Enter the total number of points available : ");

        tot = sc.nextInt();

        int[] points = new int[tot];

        System.out.print("Enter the points per move :");

        int i;

        for (i = 0; i < tot; i++) {

            points[i] = sc.nextInt();

        }

        System.out.print("Number of ways to get the score " + n + "is " + count_number_of_ways(n, points, tot));

    }

}