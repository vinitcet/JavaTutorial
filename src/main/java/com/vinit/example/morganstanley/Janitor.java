package com.vinit.example.morganstanley;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Janitor {

    public static void main(String[] args) {
        List<Float> f = Arrays.asList(1f, 1f, 1f, 1.01f, 1.99f, 1.5f, 2.5f, 2.5f, 2.5f, 2.5f, 2f);
        System.out.println(count(f));
    }

    public static int count(List<Float> f) {

        Collections.sort(f, Collections.reverseOrder());
        System.out.println(f);
        List<Float> f1 = f;
        int count = 0;
        for (int k = 0; k < f1.size()-1; k++) {
            if (f1.get(k) + f1.get(k + 1) <= 3) {
                k++;
                count++;
            } else {
                count++;
            }
        }
        return count;
    }


}
