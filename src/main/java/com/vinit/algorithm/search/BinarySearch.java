package com.vinit.algorithm.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8, 12, 14, 17, 25, 29, 31, 42, 47, 53, 55, 62};
        int search = 31;
        System.out.println(search(arr, search));
        System.out.println(searchRecursive(arr, search, 0, arr.length - 1));
    }

    public static int search(int[] arr, int text) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == text) {
                return mid;
            }
            if (text < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int searchRecursive(int[] arr, int text, int low, int high) {

        if (low == high) {
            if (arr[low] == text)
                return low;
            else
                return -1;
        } else {
            int mid = (low + high) / 2;
            if (arr[mid] == text) {
                return (low + high) / 2;
            } else if (arr[mid] < text) {
                low = mid + 1;
                return searchRecursive(arr, text, low, high);
            } else {
                high = mid - 1;
                return searchRecursive(arr, text, low, high);
            }
        }
    }

}
