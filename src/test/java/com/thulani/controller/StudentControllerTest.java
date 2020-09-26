package com.thulani.controller;

import com.thulani.entity.Student;
import com.thulani.factory.StudentFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentControllerTest {

    private static Student student = StudentFactory.createStudent("2170264", "John", "Roux");

    @Autowired
    private TestRestTemplate testRestTemplate;
    private  String url = "http://localhost:8080/student/";

    @Test
    public void a_create() {
        String studentUrl = url + "create";
        ResponseEntity<Student> studentResponseEntity = testRestTemplate.postForEntity(studentUrl, student, Student.class);
        assertNotNull(studentResponseEntity);
        assertNotNull(studentResponseEntity.getBody());
        student = studentResponseEntity.getBody();
        System.out.println("Created : " + student);
        assertEquals(student.getStudNumber(), studentResponseEntity.getBody().getStudNumber());

    }

    @Test
    public void b_read() {
    }

    @Test
    public void c_update() {
    }

    @Test
    public void d_delete() {
    }
}