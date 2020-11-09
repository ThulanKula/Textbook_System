package com.thulani.controller;

import com.thulani.entity.Textbook;
import com.thulani.factory.TextbookFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * @author aelmick
 * Des: Textbook Controller
 * date: 27 September 2020
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TextbookControllerTest {

    private static Textbook textbook = TextbookFactory.createTextbook("Harry Potter", 2, "Brand New", "9484545", 2, 12);
    private static final String SECURITY_USERNAME = "staff";
    private static final String SECURITY_PASSWORD = "2000217";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/textbook/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " +url);
        System.out.println("Post data: " +textbook);
        ResponseEntity<Textbook> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, textbook, Textbook.class);
        //assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        textbook = postResponse.getBody();
        System.out.println("Saved data: " +textbook);
        assertEquals(textbook.getBookId(), postResponse.getBody().getBookId());
        //assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse);
    }
    @Test
    public void b_read()
    {
        String url = baseURL +"read/"+ textbook.getBookId();
        System.out.println("URL: " +url);
        ResponseEntity<Textbook> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_USERNAME)
                .getForEntity(url, Textbook.class);
        assertEquals(textbook.getBookId(), Objects.requireNonNull(responseEntity.getBody()).getBookId());
    }

    @Test
    public void c_update(){
        Textbook updated = new Textbook.Builder().copy(textbook).setBookDescription("This is a demo")
                .setBookName("Lords of the rings")
                .setBookEdition(2016)
                .setBookISBN("987-456-1213")
                .setBookPrice(16.45)
                .setBookVolume(4)
                .build();
        String url = baseURL + "update";
        System.out.println("URL: " +url);
        System.out.println("Post data: " +updated);
        ResponseEntity<Textbook> responseEntity = restTemplate.postForEntity(url, updated, Textbook.class);
        assertEquals(textbook.getBookId(), Objects.requireNonNull(responseEntity.getBody()).getBookId());
    }

    @Test
    public void d_getall() {
        String url = baseURL + "all";
        System.out.println("URL: " +url);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void e_delete(){
        String url = baseURL +"delete/"+ textbook.getBookId();
        System.out.println("URL: " +url);
        restTemplate.delete(url);
    }
}