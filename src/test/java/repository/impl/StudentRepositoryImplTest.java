package repository.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentRepositoryImplTest {

   private static StudentRepository studentRepository = StudentRepositoryImpl.getStudentRepository();
    private static Student student = StudentFactory.createStudent("217026666", "Thulani", "Kula");

    @Test
    public void getAll() {
        System.out.println("Get Student: " + studentRepository.getAll());
    }


    @Test
    public void create() {
        Student s = studentRepository.create(student);
        Assert.assertEquals(s.getStudNumber(), s.getFirstName(), s.getLastName());
        System.out.println(s);
    }

    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}
