package com.vinit.example.aqr;

import java.util.HashSet;
import java.util.Set;

public class HashEqualTest {
    public static void main(String[] args) {
        Student st1 = new Student(1, "amit");
        Student st2 = new Student(2, "sumit");
        Student st11 = new Student(1, "amit");
        Student st22 = new Student(2, "sumit");
        Set<Student> st = new HashSet<>();
        st.add(st1);
        st.add(st2);
        st.add(st11);
        st.add(st22);
        st.add(st2);
        st.add(st11);
        st.add(st22);
        st.stream().forEach(s -> System.out.println(s.getName()));
    }
}
