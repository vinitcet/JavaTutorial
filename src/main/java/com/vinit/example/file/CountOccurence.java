package com.vinit.example.file;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurence {
    public static void main(String[] args) {
        Stream<Integer> str= Stream.of(1,2,3,4,2,1,2,4,1,3,4,5,2,1);
       // Map<Integer, Long> countMap= str.collect(Collectors.groupingBy(Function.identity(),Collectors.counting() ));
        //System.out.println(countMap);

        IntSummaryStatistics statistics=str.collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(statistics);

        List<String> immutableList=List.of("abc");
        Set<String> immutableSet = Set.of();
        Map.of(); //immuateble Map


    }
}
