package com.vinit.example.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] testArray = {9, 18, 33, -7, 88, 21, 44, 66, 7};
        Arrays.stream(testArray).forEach(System.out::println);
        System.out.println("*********SORTED ARRAY **********");
        sort(testArray,0,testArray.length-1);
        Arrays.stream(testArray).forEach(System.out::println);
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
     static void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
        static int partition(int arr[], int low, int high)
        {
            int pivot = arr[high];
            int i = (low-1); // index of smaller element
            for (int j=low; j<high; j++)
            {
                // If current element is smaller than or
                // equal to pivot
                if (arr[j] <= pivot)
                {
                    i++;

                    // swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // swap arr[i+1] and arr[high] (or pivot)
            int temp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = temp;

            return i+1;
        }
    }
