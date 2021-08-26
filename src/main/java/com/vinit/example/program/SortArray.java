package com.vinit.example.program;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortArray {

    public static void main(String[] args) {
        Stream<Integer> givenStream = Stream.of(-1, -4, 9, -5, 7, 8, 9, 0, -5, 1);
        List<Integer> sortedList = givenStream.sorted().collect(Collectors.toList());
        sortedList.stream().map(n -> n * n).sorted().forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        LocalDate date = LocalDate.of(1989, 8, 29);
        System.out.println(date);
        //get list of unique squares
        numbers.stream().map(n -> n * n).distinct().sorted().forEach(n -> System.out.print(n + " "));
        IntSummaryStatistics summaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("Summary statistics : " + summaryStatistics.getMax() + "  " + summaryStatistics.getMin());
        Set<Integer> mySet = sortedList.stream().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("Max ki value : " + mySet.stream().collect(Collectors.maxBy(Integer::compareTo)));
        System.out.println("Set ki value : " + mySet);

        Operation add = ((a, b) -> a + b);
        Operation sub = ((int a, int b) -> a - b);
        Operation mul = (a, b) -> a * b;
        Operation rem = (a, b) -> {
            return a % b;
        };
        Defaulttest dt = new Defaulttest() {
        };
        dt.getMesssage();
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 2, 4, 5, 6, 62, 5, 8, 9, 0);
        Map<Integer, Long> countMap=integerStream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(countMap);
    }

    @FunctionalInterface
    interface Operation {
        int op(int a, int b);
    }

    interface Defaulttest {
        default void getMesssage() {
            System.out.println("Hello World!");
        }
    }
}
