package com.thulani.service.impl;

import com.thulani.entity.Student;
import com.thulani.repository.StudentRepository;
import com.thulani.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Auhtor : Thulani Kula
 * Date: 02 Sept. 2020
 *
 * **/

@Service
public class StudentServiceImpl implements StudentService {

   @Autowired
    private StudentRepository repository;

    @Override
    public Set<Student> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Student create(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Student read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Student update(Student student) {
        return create(student);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        return true;
    }
}
