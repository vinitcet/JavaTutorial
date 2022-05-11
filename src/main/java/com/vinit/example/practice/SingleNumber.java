package com.vinit.example.practice;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumbers(nums));
    }

    public static int singleNumbers(int[] a) {
        int single = 0;
        for (int num : a) {
            System.out.println(padLeftZeros(Integer.toString(single, 2), 4));
            System.out.println(padLeftZeros(Integer.toString(num, 2), 4));
            System.out.println("----------------------");
            single ^= num;
            System.out.println(padLeftZeros(Integer.toString(single, 2), 4));
            System.out.println("*****************************");
        }
        return single;
    }

    public static int singleNumber(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for (int i : nums) {
            if (ls.contains(i)) {
                ls.remove(ls.indexOf(i));
            } else {
                ls.add(i);
            }
        }
        return ls.get(0);
    }

    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
