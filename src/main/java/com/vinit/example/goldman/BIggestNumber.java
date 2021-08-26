package com.vinit.example.goldman;

import java.util.Collections;
import java.util.Vector;


public class BIggestNumber {
    public static void main(String[] args) {
        Vector<String> arr;
        arr = new Vector<>();

        // output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }
//6054854654
    static void printLargest(Vector<String> arr) {
        Collections.sort(arr,Collections.reverseOrder());
        for(String s: arr){
            System.out.print(s);
        }
    }
}
