package com.vinit.example.apptio;

import java.util.Arrays;

public class SortedArraymerge {
    public static void main(String[] args) {

        int arr1[] = {1, 4, 7, 8, 10};
        int arr2[] = {2, 3, 9};

        int len1 = arr1.length;
        int j = 0;
        for (int i = 0; i < len1; i++) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                // swap arr2 if not sorted
//                if(arr2[j]>arr2[j+1]){
//                    int temp= arr2[i];
//                    arr2[i]= arr2[i+1];
//                    arr2[i+1]=temp;
//                }
                Arrays.sort(arr2);
            }
        }
        Arrays.stream(arr1).forEach(System.out::print);
        System.out.println();
        Arrays.stream(arr2).forEach(System.out::print);

    }

}
