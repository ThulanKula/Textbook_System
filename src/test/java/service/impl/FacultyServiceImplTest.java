package service.impl;

import entity.Faculty;
import factory.FacultyFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class FacultyServiceImplTest {

    private static FacultyService service = FacultyServiceImpl.getFacultyService();
    private static Faculty faculty = FacultyFactory.createFaculty(234,"cba");

    @org.junit.Test
    public void getAll() {
        Set<Faculty> faculty = service.getAll();
        assertEquals(1,faculty.size());
        System.out.println("Faculties: "+faculty);
    }

    @org.junit.Test
    public void create() {
        Faculty create = service.create(faculty);
        System.out.println("Created:"+create);
    }

    @org.junit.Test
    public void read() {
        Faculty read = service.read(faculty);
        System.out.println("Read:"+read);

    }

    @org.junit.Test
    public void update() {
        Faculty facultyUpdate = FacultyFactory.createFaculty(245,"xyz");
        Faculty update = service.update(facultyUpdate);
        System.out.println("Updated: "+ update);

    }

    @org.junit.Test
    public void delete() {
        Faculty delete = service.update(faculty);

    }
}