package com.vinit.example.cvent;

public class BinaryDistance {
    public static void main(String[] args) {
        String a = "111001110001010000010";//Integer.toBinaryString(124);
        System.out.println(a);
        int n = a.length();
        int currentCount = 0;
        int maxDiff = 0;
        boolean start = false;
        for (int i = 0; i < n; i++) {
            if (String.valueOf(a.charAt(i)).equalsIgnoreCase("1")) {
                start = true;
                currentCount = 0;
            } else {
                currentCount++;
                if (currentCount > maxDiff) {
                    maxDiff = currentCount;
                }
            }

        }
        System.out.println(maxDiff);
    }
}
