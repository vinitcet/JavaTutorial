package com.vinit.example.goldman;

public class Median {
    public static void main(String[] args) {
        int ar1[] = {900};
        int ar2[] = {5, 8, 10, 20};
        getMedian(ar1, ar2);
    }

    static void getMedian(int[] a1, int[] a2) {
        int len1 = a1.length;
        int len2 = a2.length;
        int len = len1 + len2;
        int a = 0;
        int b = 0;
        int m1 = 0;
        int m2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            m2 = m1;
            if (a != len1 && b != len2) {
                m1 = a1[a] > a2[b] ? a2[b++] : a1[a++];
            } else if (a != len1) {
                m1 = a1[a++];
            } else {
                m1 = a2[b++];
            }
        }
        if (len % 2 == 0) {
            System.out.println(m1 + m2 / 2);
        } else {
            System.out.println(m1);
        }

    }
}
