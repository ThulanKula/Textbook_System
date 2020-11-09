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
    private static final String USER_ROLE ="USER";
    private static final String USER_PASSWORD = "2171000";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private  String url = "http://localhost:8080/textbook/student/";

    @Test
    public void a_create() {
        String studentUrl = url + "create";
        ResponseEntity<Student> studentResponseEntity = testRestTemplate.postForEntity(studentUrl, student, Student.class);
        ResponseEntity<Student> postResponse = testRestTemplate.withBasicAuth(USER_ROLE, USER_PASSWORD)
                .postForEntity(url, student, Student.class);
        assertNotNull(studentResponseEntity);
        assertNotNull(studentResponseEntity.getBody());
        student = studentResponseEntity.getBody();
        System.out.println("Created : " + student);
        assertEquals(student.getStudNumber(), studentResponseEntity.getBody().getStudNumber());
        assertEquals(student.getFirstName(), studentResponseEntity.getBody().getFirstName());
        assertEquals(student.getLastName(), studentResponseEntity.getBody().getLastName());

    }

    @Test
    public void b_read() {
        String studentUrl = url + "read/" + student.getStudNumber();
        ResponseEntity<Student>studentResponseEntity = testRestTemplate.getForEntity(studentUrl, Student.class);
        ResponseEntity<Student> postResponse = testRestTemplate.withBasicAuth(USER_ROLE, USER_PASSWORD)
                .postForEntity(url, student, Student.class);
        assertEquals(student.getStudNumber(), studentResponseEntity.getBody().getStudNumber());
        assertEquals(student.getFirstName(), studentResponseEntity.getBody().getFirstName());
        assertEquals(student.getLastName(), studentResponseEntity.getBody().getLastName());
    }

    @Test
    public void c_update() {
        Student updated = new Student.Builder().setFirstName("John")
                .setLastName("Ruxx").setStudNumber("21777").build();
        String url2 = url + "update";
        System.out.println("URL: " +url2);
        System.out.println("Post data: " +updated);
        ResponseEntity<Student> responseEntity = testRestTemplate
                .withBasicAuth(USER_ROLE, USER_PASSWORD)
                .postForEntity(url, updated, Student.class);
        assertEquals(student.getStudNumber(), responseEntity.getBody().getStudNumber());
    }

    @Test
    public void d_delete() {
        String url2 = url +"delete/"+ student.getStudNumber();
        System.out.println("URL: " +url2);
        testRestTemplate
                .withBasicAuth(USER_ROLE, USER_PASSWORD)
                .delete(url2);
    }
}