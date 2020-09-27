package com.thulani.controller;

import com.thulani.entity.Department;
import com.thulani.factory.DepartmentFactory;
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

@SpringBootTest(classes = Department.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private int port;
    private String getURL() {
        return "http://localhost: " + port;
    }

    @Test
    public void a_testCreate() {
        Department department = DepartmentFactory.createDepartment("1010", "Informatics and Design");
        ResponseEntity<Department> postResponse = testRestTemplate.postForEntity(getURL(), department, Department.class);
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