package com.vinit.example.sorco;

public class NumberPermutation {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(countNumber(100));
    }

    static int countNumber(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i <=9) {
                count++;
            } else {
                int givenNumber = i;
                int reversed = 0;
                while (givenNumber != 0) {
                    int digit = i % 10;
                    reversed = reversed * 10 + digit;
                    givenNumber = givenNumber / 10;
                }
                if (reversed >= i) {
                    count++;
                }
            }
        }

        return count;
    }
}
