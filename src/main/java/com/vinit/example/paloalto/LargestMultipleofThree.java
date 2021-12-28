package com.vinit.example.paloalto;

import java.util.Arrays;

public class LargestMultipleofThree {

    // Number of digits
    static int MAX_SIZE = 10;

    // function to sort array of digits using
    // counts
    static void sortArrayUsingCounts(int arr[],
                                     int n) {
        // Store count of all elements
        int[] count = new int[MAX_SIZE];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Store
        int index = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // Remove elements from arr[]
    // at indexes ind1 and ind2
    static String removeAndPrintResult(int arr[], int n,
                                       int ind1, int ind2) {
        StringBuilder s = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (i != ind1 && i != ind2) {
                s.append(arr[i]);
            }
        }
        return s.toString();
    }

    // Returns largest multiple of 3
    // that can be formed using
    // arr[] elements.
    public static String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        // Sum of all array element
        int sum = accumulate(digits, 0, n);

        // Sort array element in increasing order
        sortArrayUsingCounts(digits, n);

        if(Arrays.stream(digits).sum()==0){
            return "0";
        }

        // If sum is divisible by 3,
        // no need to delete an element
        if (sum % 3 == 0) {
            return removeAndPrintResult(digits, n, -1, -1);

        }

        // Find reminder
        int remainder = sum % 3;

        // If remainder is '1', we have to
        // delete either one element of
        // remainder '1' or two elements of
        // remainder '2'
        if (remainder == 1) {
            int[] rem_2 = new int[2];
            rem_2[0] = -1;
            rem_2[1] = -1;

            // Traverse array elements
            for (int i = 0; i < n; i++) {

                // Store first element of remainder '1'
                if (digits[i] % 3 == 1) {
                    return removeAndPrintResult(digits, n, i, -1);
                }

                if (digits[i] % 3 == 2) {

                    // If this is first occurrence
                    // of remainder 2
                    if (rem_2[0] == -1) {
                        rem_2[0] = i;
                    }

                    // If second occurrence
                    else if (rem_2[1] == -1) {
                        rem_2[1] = i;
                    }
                }
            }

            if (rem_2[0] != -1 &&
                    rem_2[1] != -1) {
                return removeAndPrintResult(digits, n, rem_2[0],
                        rem_2[1]);

            }
        }

        // If remainder is '2', we have to
        // delete either one element of
        // remainder '2' or two elements of
        // remainder '1'
        else if (remainder == 2) {
            int[] rem_1 = new int[2];
            rem_1[0] = -1;
            rem_1[1] = -1;

            // traverse array elements
            for (int i = 0; i < n; i++) {

                // store first element of remainder '2'
                if (digits[i] % 3 == 2) {
                    return removeAndPrintResult(digits, n, i, -1);

                }

                if (digits[i] % 3 == 1) {

                    // If this is first occurrence
                    // of remainder 1
                    if (rem_1[0] == -1) {
                        rem_1[0] = i;
                    }

                    // If second occurrence
                    else if (rem_1[1] == -1) {
                        rem_1[1] = i;
                    }
                }
            }

            if (rem_1[0] != -1 &&
                    rem_1[1] != -1) {
                return removeAndPrintResult(digits, n, rem_1[0],
                        rem_1[1]);

            }
        }

        return "";
    }

    static int accumulate(int[] arr,
                          int start,
                          int end) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {4, 4, 1, 1, 1, 3};
        System.out.println(largestMultipleOfThree(arr));
    }

}
