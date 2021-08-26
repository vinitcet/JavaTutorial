package com.vinit.example.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Profile({"dev","test"})
public class Student {
    public Student(String name) {
        this.name = name;
    }

    public Student(int rollNumber, String name, String studentType) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.studentType = studentType;
    }

    public Student() {
    }

    private int rollNumber;
    private String name;
    private String studentType;

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
