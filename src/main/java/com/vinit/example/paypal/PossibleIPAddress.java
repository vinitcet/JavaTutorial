package com.vinit.example.paypal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PossibleIPAddress {

    public static void main(String[] args) {
        System.out.println(getIPAddress("25525511135"));
    }

    public static ArrayList<String> getIPAddress(String s) {
        ArrayList<String> al = new ArrayList<>();
        if (s.length() < 3 || s.length() > 12) {
            return al;
        }
        int size = s.length();
        String scopy = s;
        for (int i = 1; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    scopy = scopy.substring(0, k) + "." + scopy.substring(k);
                    scopy = scopy.substring(0, j) + "." + scopy.substring(j);
                    scopy = scopy.substring(0, i) + "." + scopy.substring(i);
                    if (isValid(scopy)) {
                        al.add(scopy);
                    }
                    scopy = s;
                }
            }
        }
        Collections.sort(al, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String a1[] = o1.split("[.]");
                String a2[] = o2.split("[.]");

                int result = -1;
                for (int i = 0; i < 4
                        && result != 0;
                     i++) {
                    result = a1[i].compareTo(a2[i]);
                }
                return result;
            }
        });
        return al;
    }

    private static boolean isValid(String ip) {
        String a[] = ip.split("[.]");
        for (String s : a) {
            int i = Integer.parseInt(s);
            if (s.length() > 3 || i < 0 || i > 255) {
                return false;
            }
            if (s.length() > 1 && i == 0)
                return false;
            if (s.length() > 1 && i != 0
                    && s.charAt(0) == '0')
                return false;
        }
        return true;
    }
}
