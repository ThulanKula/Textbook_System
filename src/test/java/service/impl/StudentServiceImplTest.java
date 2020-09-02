package service.impl;

import entity.Student;
import entity.Year;
import factory.StudentFactory;
import factory.YearFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.StudentService;
import service.YearService;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentServiceImplTest {

    private static StudentService service = StudentServiceImpl.getService();
    private static Student student = StudentFactory.createStudent("217026", "Thulani", "Kula");

    @Test
    public void d_getAll() {
    }

    @Test
    public void a_create() {
    }

    @Test
    public void b_read() {
    }

    @Test
    public void c_update() {
    }

    @Test
    public void f_delete() {
    }
}