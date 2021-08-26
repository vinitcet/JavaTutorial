package com.vinit.example.sorco;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        rotate(a, 4);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void rotate(int[] a, int r) {
        int count = 0;
        List<Integer> myList = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            if (i < r) {
                myList.add(a[i]);
            } else {
                a[count++] = a[i];
            }
        }
        for (int i : myList) {
            a[count++] = i;
        }
    }
}
