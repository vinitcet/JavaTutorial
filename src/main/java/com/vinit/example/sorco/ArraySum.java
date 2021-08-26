package com.vinit.example.sorco;

public class ArraySum {
    public static void main(String[] args) {
        int[] a={1,2,3,4,13,1,1,1};
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum = sum+a[i];
        }
        for(int i=0;i<a.length;i++){
            if(a[i]==sum-a[i]){
                System.out.println(a[i]+" is equal to other elements sum: "+(sum-a[i]));
            }
        }
    }
}
