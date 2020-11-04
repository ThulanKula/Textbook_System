package com.thulani.controller;

import com.thulani.entity.Author;
import com.thulani.factory.AuthorFactory;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorControllerTest {

    private static Author author = AuthorFactory.createAuthor("1010", "Louise", "Smith");

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseUrl = "http://localhost:8080/textbook/";


    @Test
    public void a_testCreate() {
        String url = baseUrl + "create";
        System.out.println("URL: "+ author);
        ResponseEntity<Author> postResponse = testRestTemplate.postForEntity(url, author, Author.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        author = postResponse.getBody();
        System.out.println("Saved data: "+ author);
        assertEquals(author.getAuthNumber(), postResponse.getBody().getAuthNumber());
    }

    @Test
    public void b_read() {
        String url = baseUrl+ "read"+author.getAuthNumber();
        System.out.println("URL: "+url);
        ResponseEntity<Author> responseEntity = testRestTemplate.getForEntity(url, Author.class);
        assertEquals(author.getAuthNumber(), responseEntity.getBody().getAuthNumber());
    }

    @Test
    public void c_testUpdate() {
        Author.Builder update2 = new Author.Builder().setAuthFirstName("John").setAuthLastName("Doe");
        String url = baseUrl+"update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+update2);
        ResponseEntity<Author> responseEntity = testRestTemplate.postForEntity(url,update2, Author.class);
        assertEquals(author.getAuthNumber(), responseEntity.getBody().getAuthNumber());
    }

    @Test
    public void d_testGetAll() {
        String url = baseUrl+"all";
        System.out.println("URL: "+url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void f_testDelete() {

        String url = baseUrl+"delete/"+author.getAuthNumber();
        System.out.println("URL: "+url);
        testRestTemplate.delete(url);
    }
}