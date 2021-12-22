package com.vinit.example.myntra;

public class ReverseWithoutAdditionalMemory {

    public static void main(String[] args) {
        String a = "Vunit";
        char[] str = a.toCharArray();
        reverse(str, 0, str.length - 1);
    }

    public static void reverse(char[] str, int start, int end) {
        while (start < end) {
            System.out.println("-->" + str[start] + " " + str[end]);
            str[start] ^= str[end];
            System.out.println(str[start] + " " + str[end]);
            str[end] ^= str[start];
            System.out.println(str[start] + " " + str[end]);
            str[start] ^= str[end];
            System.out.println(str[start] + " " + str[end]);
            start++;
            end--;
        }
        System.out.println(str);
    }

}
