package com.thulani.controller;

import com.thulani.entity.Textbook;
import com.thulani.factory.TextbookFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author aelmick
 * Des: Textbook Controller
 * date: 27 September 2020
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TextbookControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localhost:8080/textbook";

    @Test
    public void create() {
        Textbook textbook = TextbookFactory.createTextbook("Harry Potter", 2, "Brand New", "9484545", 2, 12);
        String url = baseURL + "create";
        ResponseEntity<Textbook> postResponse = testRestTemplate.postForEntity(url, textbook, Textbook.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getStatusCode());
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getStatusCode());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }
//    @Test
//    public void read()
//    {
//        ResponseEntity<Textbook> getResponse =
//    }

    @Test
    public void getall() {
        String url = baseURL + "all";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }
}