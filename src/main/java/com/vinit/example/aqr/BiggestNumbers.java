package com.vinit.example.aqr;

import java.util.Arrays;
import java.util.Scanner;

public class BiggestNumbers {

    public static void main(String[] args) {
        int[] numArray = new int[5];
        int count = 0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a number: ");
            int num = sc.nextInt();
            if (count > 4 && numArray[4] < num) {
                Arrays.sort(numArray);
                numArray[0] = num;
            } else if (count < 5) {
                Arrays.sort(numArray);
                numArray[0] = num;

            }
            count++;
            //Arrays.stream(numArray).forEach(System.out::print);
            System.out.println(Arrays.toString(numArray));
            System.out.println();
        }
    }
}
