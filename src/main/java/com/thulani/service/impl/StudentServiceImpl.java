package com.thulani.service.impl;

import com.thulani.entity.Student;
import com.thulani.repository.StudentRepository;
import com.thulani.repository.impl.StudentRepositoryImpl;
import com.thulani.service.StudentService;
import java.util.Set;

/**
 * @Auhtor : Thulani Kula
 * Date: 02 Sept. 2020
 *
 * **/

public class StudentServiceImpl implements StudentService {

    public static StudentService service = null;
    private StudentRepository repository;

    private StudentServiceImpl(){
        this.repository = StudentRepositoryImpl.getStudentRepository();
    }

    public static StudentService getService(){
        if (service == null) service = new StudentServiceImpl();
        return service;
    }

    @Override
    public Set<Student> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Student create(Student student) {
        return this.repository.create(student);
    }

    @Override
    public Student read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Student update(Student student) {
        return this.repository.update(student);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
