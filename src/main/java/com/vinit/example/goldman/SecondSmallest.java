package com.vinit.example.goldman;

public class SecondSmallest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, -20, -30, 1, -25, 1};
        int smallest = arr[1];
        int secondSmallest = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }
        }
        System.out.println("Smallest: " + smallest + " SecondSmallest: " + secondSmallest);
    }
}
