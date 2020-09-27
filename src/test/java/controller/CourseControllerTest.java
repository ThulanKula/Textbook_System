package com.thulani.controller;

import com.thulani.entity.Course;
import com.thulani.entity.Year;
import com.thulani.factory.CourseFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CourseControllerTest {
    private static Course course = CourseFactory.buildCourse("Information Technology");

    @Autowired
    private TestRestTemplate restTemplate;
    private String url = "http://localhost:8080/course/";

    @Test
    public void a_create(){
        String courseUrl = url + "create";
        ResponseEntity<Course> postResponse = restTemplate.postForEntity(courseUrl, course, Course.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        course = postResponse.getBody();
        System.out.println("Created data: " + course);
        assertEquals(course.getCourseCode(), postResponse.getBody().getCourseCode());
    }
}
