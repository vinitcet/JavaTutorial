package com.vinit.example.goldman;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class HighestAverage {

    public static void main(String[] args) {
        String student[][] = {{"jerry", "65"}, {"bob", "1"}, {"jerry", "23"}, {"jerry", "23"}, {"jerry", "100"}, {"Eric", "83"}};
        Map<String, Long> mm = new LinkedHashMap<>();
        for (int i = 0; i < student.length; i++) {
            mm.putIfAbsent(student[i][0], Long.valueOf(student[i][1]));
            mm.put(student[i][0], (mm.get(student[i][0]) + Long.valueOf(student[i][1])) / 2);
        }
        System.out.println(mm);
/*        mm = mm.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));*/
        Optional<Map.Entry<String, Long>> asd = mm.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .findFirst();
        if(asd.isPresent()){
            System.out.println(asd.get().getKey()+" : "+asd.get().getValue());
        }


    }
}
