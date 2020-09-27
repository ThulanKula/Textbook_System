package com.thulani.controller;

import com.thulani.entity.Subject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SubjectControllerTest {

    private static Subject subject = SubjectFactory.createSubject("ADP136S", "AppDev");

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String url = "http://localhost:8080/subject";

    @Test
    public void a_create(){
        String subjectUrl = url + "create";
        Response<Subject> postResponse = testRestTemplate.postForEntity(subjectUrl, subject, Subject.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        subject = postResponse.getBody();
        System.out.println("Created: " + subject);
        assertEquals(year.getSubject(), postResponse.getResponse.getBody().getSubject());
    }

    @Test
    public void b_read(){
        String subjectUrl = url + "read/" + subject.getSubNumber();
        ResponseEntity<Subject>subjectResponseEntity = testRestTemplate.getForEntity(subjectUrl, Year.class);
        assertEquals(subject.getSubNumber(), subjectResponseEntity.getBody().getSubNumber());
    }

    @Test
    public void c_update(){

    }

    @Test
    public void d_delete(){

    }

    @Test
    public void f_getAll(){

    }

}
