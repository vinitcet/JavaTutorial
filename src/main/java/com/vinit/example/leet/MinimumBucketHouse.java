package com.vinit.example.leet;

public class MinimumBucketHouse {
    public static void main(String[] args) {
        String street = "H..H";
        System.out.println(minimumBuckets(street));
    }

    public static int minimumBuckets(String street) {
        if (("H" + street + "H").contains("HHH")) {
            return -1;
        }
        int doubles = 0;
        for (int i = street.indexOf("H.H"); i != -1; i = street.indexOf("H.H", i + 3)) doubles++;
        return (int) street.chars().filter(ch -> ch == 'H').count() - doubles;
    }
}
