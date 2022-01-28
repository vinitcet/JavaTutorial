package com.vinit.example.leet;

public class ValidMountain {
    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 1};
        int[] arr2 = {2, 1};
        //validMountainArray(arr2);
        System.out.println(validMountainArray(arr2));
    }

    public static boolean validMountainArray(int[] arr) {
        int N = arr.length;
        int i = 0;

        // walk up
        while (i + 1 < N && arr[i] < arr[i + 1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N - 1)
            return false;

        // walk down
        while (i + 1 < N && arr[i] > arr[i + 1])
            i++;
        return i == N - 1;
    }
}
