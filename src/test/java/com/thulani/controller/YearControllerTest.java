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

    @Autowired
    private TestRestTemplate testRestTemplate;
    private  String url = "http://localhost:8080/year/";

    @Test
    public void a_create() {
        String yearUrl = url + "create";
        ResponseEntity<Year> postResponse = testRestTemplate.postForEntity(yearUrl, year, Year.class);
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
        assertEquals(year.getYear(), yearResponseEntity.getBody().getYear());
    }

    @Test
    public void c_update() {
    }

    @Test
    public void f_delete() {
    }

    @Test
    public void d_getAll() {
    }
}