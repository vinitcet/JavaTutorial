package com.vinit.example.deshaw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Wordladder {
    public static void main(String[] args) {
        List<String> D = new ArrayList<String>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";

        int startP = IntStream.range(0, start.length()).map(start::charAt).sum();
        int stopP = IntStream.range(0, target.length()).map(target::charAt).sum();
        if (startP > stopP) {
            int temp = startP;
            startP = stopP;
            stopP = temp;
        }
        Map<Integer, String> myMap = new TreeMap<>();
        for (String s : D) {
            int i = IntStream.range(0, s.length()).map(s::charAt).sum();
            myMap.putIfAbsent(i, s);
        }
        System.out.println(myMap);
        int count = 2;
        for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
            if (entry.getKey() > startP && entry.getKey() < stopP) {
                System.out.print(entry.getValue() + "->");
                count++;
            }
        }
        System.out.println();
        System.out.println("Elements in chain is :" + count);

    }
}
