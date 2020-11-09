package com.thulani.controller;

import com.thulani.entity.Subject;
import com.thulani.entity.Textbook;
import com.thulani.factory.SubjectFactory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectControllerTest {
    private static Subject subject = SubjectFactory.createSubject("ADP362S", "ADP");
    private static String SECURITY_USERNAME = "student";
    private static String SECURITY_PASSWORD = "2171000";


    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localhost:8080/textbook/subject/";


    @Test
    public void create(){
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data " + subject);
        ResponseEntity<Subject> postResponse = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, subject, Subject.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        subject = postResponse.getBody();
        System.out.println("Saved data: " + subject);
        assertEquals(subject.getSubNumber(), postResponse.getBody().getSubNumber());
    }

    @Test
    public void read(){
        String url = baseURL + "read/" + subject.getSubNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Subject> responseEntity = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Subject.class);
        assertEquals(subject.getSubNumber(), responseEntity.getBody().getSubNumber());
    }

    @Test
    public void update(){
        Subject updated = new Subject.Builder().copy(subject).setSubName("Demo")
                .setSubNumber("ADP362S").build();
        String url = baseURL + "update";
        System.out.println("URL: " +url);
        System.out.println("Post data: " +updated);
        ResponseEntity<Subject> responseEntity = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Subject.class);
        assertEquals(subject.getSubNumber(), responseEntity.getBody().getSubNumber());
    }

    @Test
    public void delete(){
        String url = baseURL +"delete/"+ subject.getSubNumber();
        System.out.println("URL: " +url);
        testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Test
    public void getall() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

}
