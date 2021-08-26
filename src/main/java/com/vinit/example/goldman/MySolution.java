package com.vinit.example.goldman;

public class MySolution {

    static int noOfWaysToDrawTheGame(int totalScore) {
        if (totalScore < 2) {
            return 0;
        }
        if (totalScore % 2 != 0) {
            return 0;
        }
        int count = 0;
        if (totalScore % 2 == 0) {
            count++;
        }
        if (totalScore % 4 == 0) {
            count++;
        }
        if (totalScore % 6 == 0) {
            count++;
        }
        //Comination of digits

            return count;
    }

    public static void main(String[] args) {

        System.out.println(noOfWaysToDrawTheGame(6));
    }
}
