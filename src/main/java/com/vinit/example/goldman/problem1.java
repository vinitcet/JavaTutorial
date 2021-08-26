package com.vinit.example.goldman;

import java.io.IOException;
import java.util.Arrays;

public class problem1 {


    // Complete the noOfWaysToDrawTheGame function below.
    static int noOfWaysToDrawTheGame(int totalScore) {
        if (totalScore < 2) {
            return 0;
        }

        if (totalScore % 2 != 0) {
            return 0;
        }

        int table[] = new int[totalScore + 1];
        int i;

        Arrays.fill(table, 0);

        table[0] = 1;

        for (i = 2; i <= totalScore; i++) {
            table[i] += table[i - 2];
        }
        for (i = 4; i <= totalScore; i++) {
            table[i] += table[i - 4];
        }
        for (i = 6; i <= totalScore; i++) {
            table[i] += table[i - 6];
        }
        return table[totalScore];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(noOfWaysToDrawTheGame(6));
        System.out.println(String.valueOf(-1));
        try {
            Integer.parseInt("asd");
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
}
