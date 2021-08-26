package com.vinit.example.goldman;

public class PascalTriangle {

    public static void main(String[] args) {
        int prev = 1;
        int sz = 5;
        for (int i = 0; i <= sz; i++) {
            if (i == 0) {
                System.out.print(prev + " ");
            } else {
                //nCr = (nCr-1 * (n - r + 1))/r
                int curr = (prev * (sz - i + 1)) / i;
                System.out.print(curr + " ");
                prev = curr;
            }
        }
    }
}
