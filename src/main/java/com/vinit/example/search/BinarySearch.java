package com.vinit.example.search;

public class BinarySearch {

    public static void search(int[] arr, int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] > key) {
                last = mid - 1;
            } else {
                System.out.println("Element is found at ::" + mid);
                break;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Element is not present");
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        int key = 30;
        int last = arr.length - 1;
        search(arr, 0, last, key);
    }
}
