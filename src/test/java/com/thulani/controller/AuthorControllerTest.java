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
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
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
    }

    @Test
    public void b_findById() {
        Author searchFor = testRestTemplate.getForObject(getURL() + "/find/"+"1010", Author.class);

        assertNotNull(searchFor);
    }

    @Test
    public void c_testUpdate() {
        Author update = testRestTemplate.getForObject(getURL()+"/find/" + "1010", Author.class);
        Author.Builder update2 = new Author.Builder().setAuthFirstName("John").setAuthLastName("Doe");
        testRestTemplate.put(getURL() + "/update/"+"1010",update2);
        Author updated = testRestTemplate.getForObject(getURL() + "/update/"+"1010",Author.class);

        assertNotNull(updated);
    }

    @Test
    public void d_testGetAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(getURL() + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void f_testDelete() {


        try {
            Author author = testRestTemplate.getForObject(getURL() + "/find/" + "1010", Author.class);
            TestCase.assertNotNull(author);

            testRestTemplate.delete(getURL() + "/delete/" + "1010");
            author = testRestTemplate.getForObject(getURL() + "/find/" + "1010", Author.class);
            System.out.println(author);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}