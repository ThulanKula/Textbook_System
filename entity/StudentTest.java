package com.thulani.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    Student.Builder builder;

    @Before
    public void setUp() {
        builder = new Student.Builder();
    }

    @Test
    public void correctBuild() {
        Student student = builder.setFirstName("Thulani")
                .setLastName("Kula")
                .setStudNumber("217026")
                .build();

        System.out.println(student.toString());
    }
}