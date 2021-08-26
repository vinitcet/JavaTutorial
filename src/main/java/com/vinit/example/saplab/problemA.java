package com.vinit.example.saplab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class problemA {

    public static void main(String[] args) {
        int numberOfCase;
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        int numberCount;
        String lineWithNumbers;
        int caseNumber = 1;
        String oddNumber = null;
        numberOfCase = in.nextInt();
        while (numberOfCase > 0) {
            numberCount = in.nextInt();
            lineWithNumbers = in.next();
            String[] numberArr = lineWithNumbers.split(" ");
            Map<String, Long> countMap = Arrays.asList(numberArr).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            for (Map.Entry<String, Long> entry : countMap.entrySet()) {
                if (entry.getValue() < 2) {
                    oddNumber = entry.getKey();
                    break;
                }
            }
            System.out.println("Case #" + caseNumber + ": " + oddNumber);
            numberOfCase--;
            caseNumber++;
        }
    }
}