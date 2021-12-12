package com.vinit.example.dynamic;

//number of combination of 0 and 1
//no 1 can occur simultaneously
//1= 0 ,1
//2= 00, 01,10,
public class ZeroOne {
    public static void main(String[] args) {
        System.out.println(getCombination(8));
    }

    public static int getCombination(int a) {
        int countList[] = new int[a];
        countList[0] = 1;
        countList[1] = 3;
        for (int i = 2; i < a; i++) {
            countList[i] = countList[i - 1] + countList[i - 2];
        }
        return countList[a - 1];
    }
}
