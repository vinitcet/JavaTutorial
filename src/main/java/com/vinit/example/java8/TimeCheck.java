package com.vinit.example.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TimeCheck  implements  FunInterface{
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDateTime dttm= LocalDateTime.now();
        System.out.println(dttm);
        Stream<String> st = Stream.iterate("", (str) -> str + "x");
        System.out.println(st);
        System.out.println(st.limit(3).map(str -> str + "y"));
        new Thread(()->{
            System.out.println("In new thread: " + Thread.currentThread().getName());
        }).start();

        FunInterface f = new TimeCheck();
        f.print();
        f.printHello();
        FunInterface.getHello();

        FunInterface print = f::print;
        Predicate<String> p =s ->s.contains("abc");
        Predicate<String> pa = p.and(s->s.endsWith("end"));

        Function<String , String> fun = s->s.substring(2);
        System.out.println(fun.apply("Vinit kumar"));


    }

    @Override
    public void print() {
        System.out.println("Implementing class");
    }
}
