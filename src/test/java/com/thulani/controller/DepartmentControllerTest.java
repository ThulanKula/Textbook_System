package com.thulani.controller;

import com.thulani.entity.Department;
import com.thulani.factory.DepartmentFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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

public class DepartmentControllerTest {

    private static Department department = DepartmentFactory.createDepartment("Informatics and Design");

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localhost:8080/department/";

    @Test
    public void a_createTest() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + department);
        ResponseEntity<Department> postResponse = testRestTemplate
                .postForEntity(url, department, Department.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        department = postResponse.getBody();
        System.out.println("Saved data: " + department);
        assertEquals(department.getDepartmentNum(), postResponse.getBody().getDepartmentNum());
    }

    @Test
    public void b_readTest() {
        String url = baseURL + "read/" + department.getDepartmentNum();
        System.out.println("URL: " + url);
        ResponseEntity<Department> responseEntity = testRestTemplate.getForEntity(url, Department.class);
        assertEquals(department.getDepartmentNum(), responseEntity.getBody().getDepartmentNum());
    }

    @Test
    public void c_updateTest() {
        Department update = new Department.Builder().copy(department).setDepartmentName("Public Management").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Department> responseEntity = testRestTemplate.postForEntity(url, update, Department.class);
        assertEquals(department.getDepartmentNum(), responseEntity.getBody().getDepartmentNum());
    }

    @Test
    @Ignore
    public void d_deleteTest() {
        String url = baseURL + "delete/" + department.getDepartmentNum();
        System.out.println("URL: " + url);
        testRestTemplate.delete(url);
    }

    @Test
    public void e_getAllTest() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders head = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, head);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}