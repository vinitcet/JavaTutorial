package com.vinit.example;

import com.vinit.example.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.function.Function.identity;

public class Test {
    public static void main(String[] args) {
        System.out.println("Kaise Ho Bhai");
        Set s111= new HashSet();
        Set s2222= new HashSet();
        s111.retainAll(s2222);


        Student s1 = new Student(1, "Vinit", "Regular");
        Student s2 = new Student(2, "Amit", "Regular");
        Student s3 = new Student(3, "Sumit", "DayScholar");
        Student s4 = new Student(4, "Lalit", "DayScholar");
        Student s5 = new Student(5, "Prakrit", "Regular");

        HashSet<String> se= new HashSet();
        HashSet<String> ss= new HashSet();
se.retainAll(ss);
        List<Student> slist = new ArrayList<>();
        slist.add(s1);
        slist.add(s2);
        slist.add(s3);
        slist.add(s4);
        slist.add(s5);
        //slist.forEach(st -> System.out.println(st.getName()));
long time= System.nanoTime();
        List<Student> regularList = slist.parallelStream().filter(s -> s.getStudentType().equalsIgnoreCase("regular")).
                                    sorted(Comparator.comparing(Student::getName).reversed()).collect(Collectors.toList());
        System.out.println(System.nanoTime()-time);
        regularList.forEach(st -> System.out.println(st.getName()));

        List<Integer> ls= Arrays.asList(1,5,9,76,98,34,78);
        System.out.println(ls.stream().reduce(1,Integer::max));

        IntStream.range(0,100).filter(n->n%2==0).limit(5).forEach(System.out::println);

        Stream<String> words = Stream.of("My name is vinit kumar . what is your name");

        Map<String, Long> letterToCount =
                words.map(w -> w.split(" "))
                        .flatMap(Arrays::stream)
                        .collect(groupingBy(identity(), counting()));
        System.out.println(letterToCount);
        try {
            Files.lines(Paths.get("C:\\Users\\vinit\\Downloads\\List.txt")).map(l->l.split("-")).flatMap(Arrays::stream).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

