package com.vinit.example.leet;

import java.util.ArrayList;
import java.util.List;

public class CountHidden {
    public static void main(String[] args) {
        int[] differences = {1, -3, 4};
        int lower = 1;
        int upper = 6;
        System.out.println(numberOfArrays(differences, lower, upper));
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        if (differences == null || differences.length < 1) {
            return 0;
        }
        if (upper < lower) {
            return 0;
        }
        int sol = 0;
        List<Integer> myList = new ArrayList<>();
        for (int i = lower; i <= upper; i++) {
            myList.add(i);
        }
        List<List<Integer>> ml = new ArrayList<>();

        for (int i = upper; i >= lower; i--) {
            List<Integer> fl = new ArrayList<>();
            if (myList.contains(i - differences[0])) {
                fl.add(i - differences[0]);
                fl.add(i);
                ml.add(fl);
            }
        }
        a:
        for (int i = 0; i < ml.size(); i++) {
            List<Integer> gl = myList;
            List<Integer> ll = ml.get(i);
            gl.removeAll(ll);
            try {
                for (int j = 1; j < differences.length; j++) {
                    if (gl.contains((ll.get(i + 1) + differences[j]))) {
                        gl.remove((ll.get(i + 1) + differences[j]));
                        ll.add((ll.get(i + 1) + differences[j]));
                    } else {
                        continue a;
                    }
                }
                System.out.println("One solution is: ");
                ll.stream().forEach(System.out::println);
                sol++;
            } catch (Exception e) {

            }
        }

        return sol;
    }
}
