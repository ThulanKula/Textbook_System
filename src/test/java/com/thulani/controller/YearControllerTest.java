package com.thulani.controller;

import com.thulani.entity.Year;
import com.thulani.factory.YearFactory;
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

public class YearControllerTest {

    private static Year year = YearFactory.createYear("2");
    private static final String USER_ROLE ="USER";
    private static final String USER_PASSWORD = "2171000";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private  String url = "http://localhost:8080/textbook/year/";

    @Test
    public void a_create() {
        String yearUrl = url + "create";
      //  ResponseEntity<Year> postResponse = testRestTemplate.postForEntity(yearUrl, year, Year.class);
        ResponseEntity<Year> postResponse = testRestTemplate.withBasicAuth(USER_ROLE, USER_PASSWORD)
                .postForEntity(url, year, Year.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        year = postResponse.getBody();
        System.out.println("Created: " + year);
        assertEquals(year.getYear(), postResponse.getBody().getYear());
    }

    @Test
    public void b_read() {
        String yearUrl = url + "read/" + year.getYear();
       ResponseEntity<Year>yearResponseEntity = testRestTemplate.getForEntity(yearUrl, Year.class);
        ResponseEntity<Year> postResponse = testRestTemplate.withBasicAuth(USER_ROLE, USER_PASSWORD)
                .postForEntity(url, year, Year.class);
        assertEquals(year.getYear(), yearResponseEntity.getBody().getYear());
    }

    @Test
    public void c_update() {
        Year updated = new Year.Builder().setYear("3").build();
        System.out.println("Post data: " +updated);
        ResponseEntity<Year> responseEntity = testRestTemplate
                .withBasicAuth(USER_ROLE, USER_PASSWORD)
                .postForEntity(url, updated, Year.class);
        assertEquals(year.getYear(), responseEntity.getBody().getYear());
    }

    @Test
    public void f_delete() {
        String url2 = url +"delete/"+ year.getYear();
        System.out.println("URL: " +url2);
        testRestTemplate
                .withBasicAuth(USER_ROLE, USER_PASSWORD)
                .delete(url2);
    }

    @Test
    public void d_getAll() {
    }
}