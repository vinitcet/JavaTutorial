package com.vinit.example.dynamic;

public class Fibonacci {
    //1,1,2,3,5,8,13,21... 12586269025
    public static void main(String[] args) {
        long l = System.nanoTime();
        System.out.println(getFibonacciRecursion(25));
        System.out.println("Time Taken:: " + (System.nanoTime() - l));
        long l2 = System.nanoTime();
        System.out.println(getFibonacciDynamic(25));
        System.out.println("Time Taken:: " + (System.nanoTime() - l2));


    }

    static int getFibonacciRecursion(int n) {
        if (n < 1) {
            return -1;
        } else if (n <= 2) {
            return 1;
        }
        return getFibonacciRecursion(n - 1) + getFibonacciRecursion(n - 2);
    }

    static int getFibonacciDynamic(int n) {
        int f[] = new int[n + 2];
        int i;
        f[0] = 0;
        f[1] = 1;
        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}

