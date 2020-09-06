package service.impl;

import entity.Student;
import factory.StudentFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.StudentService;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentServiceImplTest {

    private static StudentService service = StudentServiceImpl.getService();
    private static Student student = StudentFactory.createStudent("217026", "Thulani", "Kula");

    @Test
    public void d_getAll() {
        Set<Student> student = service.getAll();
        assertEquals(1, student.size());
        System.out.println("All students: " + students);
    }

    @Test
    public void a_create() {
        Student created = service.create(student);
        Assert.assertEquals(created.getStudNumber(), created.getFirstName(), created.getLastName());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Student read = service.read(student.getStudNumber(), student.getFirstName(), student.getLastName());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(student.getStudNumber(), student.getFirstName(), student.getLastName());
        Assert.assertTrue(deleted);
    }
}
