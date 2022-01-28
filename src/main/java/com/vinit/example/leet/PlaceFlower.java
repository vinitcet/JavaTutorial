package com.vinit.example.leet;

public class PlaceFlower {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1, 0, 0};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i + 1] == 0) {
                    if (i + 2 == flowerbed.length) {
                        count++;
                        i++;
                    } else if (flowerbed[i + 2] == 0) {
                        count++;
                        i++;
                    }
                }
                if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    count++;
                    i++;
                }
            }
        }
        return count == n;
    }
}