package com.thulani.controller;

import com.thulani.entity.Course;
import com.thulani.factory.CourseFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CourseControllerTest {
<<<<<<< HEAD
<<<<<<< HEAD
    private static Course course = CourseFactory.buildCourse("Nursing");
    private static String SECURITY_USERNAME = "student";
    private static String SECURITY_PASSWORD = "2171000";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Textbook_System/course/";
=======
    private static Course course = CourseFactory.buildCourse("Information Technology");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/course/";
>>>>>>> parent of 00eb900... security commit
=======
    private static Course course = CourseFactory.buildCourse("Information Technology");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/course/";
>>>>>>> parent of 00eb900... security commit

    @Test
    public void acreate(){
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + course);
        ResponseEntity<Course> postResponse = restTemplate.postForEntity(url, course, Course.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        course = postResponse.getBody();
        System.out.println("Created data: " + course);
        assertEquals(course.getCourseCode(), postResponse.getBody().getCourseCode());
    }

    @Test
    public void bread()
    {
        String url = baseURL +"read/"+ course.getCourseCode();
        System.out.println("URL: " +url);
        ResponseEntity<Course> responseEntity = restTemplate.getForEntity(url, Course.class);
        assertEquals(course.getCourseCode(), responseEntity.getBody().getCourseCode());
    }

    @Test
    public void cupdate(){
        Course updated = new Course.Builder().copy(course)
<<<<<<< HEAD
<<<<<<< HEAD
                .setCourseName("Advanced Nursing").build();
=======
                .setCourseName("INFORMATION & COMMUNICATIONS TECHNOLOGY").build();
>>>>>>> parent of 00eb900... security commit
=======
                .setCourseName("INFORMATION & COMMUNICATIONS TECHNOLOGY").build();
>>>>>>> parent of 00eb900... security commit
        String url = baseURL + "update";
        System.out.println("URL: " +url);
        System.out.println("Updated data: " +updated);
        ResponseEntity<Course> responseEntity = restTemplate.postForEntity(url, updated, Course.class);
        assertEquals(course.getCourseCode(), responseEntity.getBody().getCourseCode());
    }

    @Test
    public void dgetall() {
        String url = baseURL + "all data";
        System.out.println("URL: " +url);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }

    @Test
    @Ignore
    public void edelete(){
        String url = baseURL +"delete/"+ course.getCourseCode();
        System.out.println("URL: " +url);
        restTemplate.delete(url);
    }
}
