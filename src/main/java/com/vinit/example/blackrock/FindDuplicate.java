package com.vinit.example.blackrock;

import java.util.Arrays;

public class FindDuplicate {

    // Driver code
    public static void main(String[] args) {

        int numRay[] = {9, 9, 0, 4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("numray ka size" + numRay.length);
        for (int i = 0; i < numRay.length; i++) {
            System.out.println(numRay[i] % numRay.length+ " = "+ numRay.length);
            numRay[numRay[i] % numRay.length]
                    = numRay[numRay[i] % numRay.length]
                    + numRay.length;
        }
       for(int i : numRay){
           System.out.print( i +" ");
       }
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < numRay.length; i++) {
            if (numRay[i] >= numRay.length * 2) {
                System.out.println(i + " ");
            }
        }
    }
}
