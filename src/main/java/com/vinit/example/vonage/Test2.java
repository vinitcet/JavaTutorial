package com.vinit.example.vonage;
/*
Write a function solution that, given a three-digit Integer N and an Integer K, returns the maximum possible three-digit
value that can be obtained by performing at most K Increases by 1 of any digit in N.
*/


public class Test2 {
    public static void main(String[] args) {
        solution(512, 10);
    }

    static int solution(int N, int K) {
        if (N < 100 || N > 999) {
            return 0;
        } else if (K < 0 || K > 30) {
            return 0;
        }
        int firstNumber = N / 100;
        int secondNumber = (N % 100) / 10;
        int thirdNumber = N % 10;
        if (firstNumber < 9 && K > 0) {
            int diff = 9 - firstNumber;
            if (K > diff) {
                firstNumber = 9;
                K = K - diff;
            } else {
                firstNumber = firstNumber + K;
                K = 0;
            }
        }
        if (secondNumber < 9 && K > 0) {
            int diff = 9 - secondNumber;
            if (K > diff) {
                secondNumber = 9;
                K = K - diff;
            } else {
                secondNumber = secondNumber + K;
                K = 0;
            }
        }
        if (thirdNumber < 9 && K > 0) {
            int diff = 9 - thirdNumber;
            if (K > diff) {
                thirdNumber = 9;
                K = K - diff;
            } else {
                thirdNumber = thirdNumber + K;
                K = 0;
            }
        }

        System.out.println(firstNumber + " : " + secondNumber + " : " + thirdNumber + "");

        System.out.println(firstNumber * 100 + secondNumber * 10 + thirdNumber);
        return firstNumber * 100 + secondNumber * 10 + thirdNumber;
    }
}
