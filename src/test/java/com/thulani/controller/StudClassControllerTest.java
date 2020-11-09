package com.thulani.controller;

import com.thulani.entity.StudClass;
import com.thulani.factory.StudClassFactory;
import org.junit.FixMethodOrder;
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

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudClassControllerTest {

    private static StudClass studClass = StudClassFactory.createStudClass("Information Technology");
    private static String SECURITY_NAME ="student";
    private static String SECURITY_PASSWORD = "2171000";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseUrl = "http://localhost:8080/textbook/StudClass";


    @Test
    public void a_testCreate() {
        String url = baseUrl + "create";
        System.out.println("URL: "+ studClass);
        ResponseEntity<StudClass> postResponse = testRestTemplate.withBasicAuth(SECURITY_NAME, SECURITY_PASSWORD).postForEntity(url, studClass, StudClass.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        studClass = postResponse.getBody();
        System.out.println("Created data: "+ studClass);
        assertEquals(studClass.getStudCourseId(), postResponse.getBody().getStudCourseId());
    }

    @Test
    public void b_read() {
        String url = baseUrl+ "read"+studClass.getStudCourseId();
        System.out.println("URL: "+url);
        ResponseEntity<StudClass> responseEntity = testRestTemplate.withBasicAuth(SECURITY_NAME, SECURITY_PASSWORD).getForEntity(url, StudClass.class);
        assertEquals(studClass.getStudCourseId(), responseEntity.getBody().getStudCourseId());
    }

    @Test
    public void c_testUpdate() {
        StudClass updated = new StudClass.Builder().copy(studClass).setStudCourse("Information Technology : Application Development").build();
        String url = baseUrl+"update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<StudClass> responseEntity = testRestTemplate.withBasicAuth(SECURITY_NAME, SECURITY_PASSWORD).postForEntity(url,updated, StudClass.class);
        assertEquals(studClass.getStudCourseId(), responseEntity.getBody().getStudCourseId());
    }

    @Test
    public void d_testGetAll() {
        String url = baseUrl+"all";
        System.out.println("URL: "+url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.withBasicAuth(SECURITY_NAME, SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void f_testDelete() {

        String url = baseUrl+"delete/"+studClass.getStudCourseId();
        System.out.println("URL: "+url);
        testRestTemplate.withBasicAuth(SECURITY_NAME, SECURITY_PASSWORD).delete(url);
    }
}