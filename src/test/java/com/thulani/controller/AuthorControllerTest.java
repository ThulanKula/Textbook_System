package com.thulani.controller;

import com.thulani.entity.Author;
import com.thulani.factory.AuthorFactory;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
    private static String SECURITY_USERNAME = "student";
    private static String SECURITY_PASSWORD = "2172000";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseUrl = "http://localhost:8080/textbook/author/";


    @Test
    public void a_Create() {
        String url = baseUrl + "create";
        System.out.println("URL: "+ url);
        System.out.println("Post data: "+author);
        ResponseEntity<Author> postResponse = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, author, Author.class);
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
        ResponseEntity<Author> responseEntity = testRestTemplate.
                withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Author.class);
        assertEquals(author.getAuthNumber(), responseEntity.getBody().getAuthNumber());
    }

    @Test
    public void c_Update() {
        Author update = new Author.Builder().copy(author)
                .setAuthFirstName("John").setAuthLastName("Doe").Build();
        String url = baseUrl+"update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+update);
        ResponseEntity<Author> responseEntity = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,update, Author.class);
        assertEquals(author.getAuthNumber(), responseEntity.getBody().getAuthNumber());
    }

    @Test
    public void d_GetAll() {
        String url = baseUrl+"all";
        System.out.println("URL: "+url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    @Ignore
    public void f_Delete() {

        String url = baseUrl+"delete/"+author.getAuthNumber();
        System.out.println("URL: "+url);
        testRestTemplate
        .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
        .delete(url);
    }
}