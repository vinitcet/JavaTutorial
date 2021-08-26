package com.vinit.example.sorco;

public class CookiesJar {

    public static void main(String[] args) {
        int[] a = {12, 27, 19, 13, 11};
        maxEat(a);
    }

    static void maxEat(int[] a) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                sumOdd += a[i];
            } else {
                sumEven += a[i];
            }
        }
        System.out.println(sumEven + " " + sumOdd);
    }
}
