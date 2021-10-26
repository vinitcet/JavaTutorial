package com.vinit.example.vonage;

/*
There are two wooden sticks of lengths A and B respectively. Each of them can be cut into shorter sticks of integer lengths.
4Our goal is to construct the largest possible square. In order to do this, we want to cut the sticks in such a way as to achieve
four sticks of the same length (note that there can be some leftover pieces). What is the longest side of square that we can achieve?
*/
public class Test3 {
    public static void main(String[] args) {

    }

    static int solution(int A, int B) {
        if (A < 1 || A > 1000000000 || B < 1 || B > 1000000000) {
            return 0;
        }
        int a = A / 4;
        int b = Math.min(A, B / 3);
        int c = Math.min(A / 2, B / 2);
        int d = Math.min(A / 3, B);
        int e = B / 4;
        return Math.max(a, Math.max(b, Math.max(c, Math.max(d, e))));
    }
}
