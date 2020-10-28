package com.thulani.service.impl;

import com.thulani.entity.Student;
import com.thulani.entity.Year;
import com.thulani.factory.StudentFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.thulani.service.StudentService;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentServiceImplTest {

    private static StudentService service;
    private static Student student = StudentFactory.createStudent("217026", "Thulani", "Kula");

    @Test
    public void d_getAll() {
        Set<Student> student = service.getAll();
       assertNotNull(student);
    }

    @Test
    public void a_create() {
        Student created = service.create(student);
        assertEquals(student.getStudNumber(), created.getStudNumber());
        assertEquals(student.getFirstName(), created.getFirstName());
    }

    @Test
    public void b_read() {
        Student read = service.read(student.getStudNumber());
        assertNotNull(read);
    }

    @Test
    public void c_update() {
        Student updated = new Student.Builder().setStudNumber("21026").setFirstName("Thulani").setLastName("Kula").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
        
    }

    @Test
    public void f_delete() {
      //  boolean deleted = service.delete(student.getStudNumber(), student.getFirstName(), student.getLastName());
       // Assert.assertTrue(deleted);
    }
}
