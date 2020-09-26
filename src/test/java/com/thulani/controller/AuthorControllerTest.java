package com.thulani.controller;

import com.thulani.entity.Author;
import com.thulani.factory.AuthorFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = Author.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private int port;
    private String getURL() {
        return "http://localhost: " + port;
    }

    @Test
    public void a_testCreate() {
        Author author = AuthorFactory.createAuthor("1010", "Louise", "Smith");
        ResponseEntity<Author> postResponse = testRestTemplate.postForEntity(getURL(), author, Author.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());

    }

    @Test
    public void b_testRead() {
    }

    @Test
    public void c_testUpdate() {
    }

    @Test
    public void d_testGetAll() {
    }

    @Test
    public void f_testDelete() {

    }
}