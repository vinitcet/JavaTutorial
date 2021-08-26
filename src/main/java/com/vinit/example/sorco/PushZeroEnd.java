package com.vinit.example.sorco;

import java.util.ArrayList;
import java.util.List;

public class PushZeroEnd {
    public static void main(String[] args) {
        int[] a = {1, 0, -3, 4, 9, 0, -8, 6};
        //Arrays.asList(a).forEach(System.out::println);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        // List<Integer> ol=pushZero(a);
        //ol.toArray();
        push(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void push(int[] a, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] != 0) {
                a[count++] = a[i];
            }
        }
        while (count < length) {
            a[count++] = 0;
        }
    }

    public static List pushZero(int[] a) {
        List<Integer> first = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        int[] l = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                last.add(a[i]);
            } else {
                first.add(a[i]);
            }
        }
        first.addAll(last);
        return first;
    }
}
