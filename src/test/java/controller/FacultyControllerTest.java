package com.thulani.controller;

import com.thulani.entity.Course;
import com.thulani.entity.Faculty;
import com.thulani.entity.Year;
import com.thulani.factory.FacultyFactory;
import com.thulani.factory.YearFactory;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FacultyControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private int port;
    private String getURL() {
        return "http://localhost: " + port;
    }

    private static Faculty faculty = FacultyFactory.createFaculty("1234", "Design");



    @org.junit.Test
    public void create() {
        String facultyUrl = url + "create";
        ResponseEntity <Faculty> postResponse = testRestTemplate.postForEntity(facultyUrl, faculty, Faculty.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        faculty = postResponse.getBody();
        System.out.println("Created Faculty: " + faculty.getFacultyName());
        assertEquals(faculty.getFacultyNum(), postResponse.getBody().getFacultyNum());


    }

    @org.junit.Test
    public void read() {
    }

    @org.junit.Test
    public void update() {
    }

    @org.junit.Test
    public void delete() {
    }

    @org.junit.Test
    public void getAll() {
    }
}