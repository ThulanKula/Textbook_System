package com.thulani.repository.impl;

import com.thulani.entity.Student;
import com.thulani.repository.StudentRepository;

import java.util.Set;
/***
 * @Author : Thulani Kula
 * Date : 25 August 2020
 *
 * */

/*
public class StudentRepositoryImpl implements StudentRepository {
    public static StudentRepository studentRepository = null;
    private Set <Student> studentDB;

    public static StudentRepository getStudentRepository(){
        if (studentRepository == null) studentRepository = new StudentRepositoryImpl();
        return studentRepository;
    }

    @Override
    public Set<Student> getAll() {
        return this.studentDB;
    }

    @Override
    public Student create(Student student) {
        this.studentDB.add(student);
        return student;
    }

    @Override
    public Student read(String ID) {
        for (Student student : this.studentDB){
            if (student.getStudNumber().equalsIgnoreCase(ID)) return student;
        }
        return null;
    }

    @Override
    public Student update(Student student) {

        boolean deleteStudent = delete(student.getStudNumber());
        if (deleteStudent){
            this.studentDB.add(student);
            return student;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }


  /*  public boolean delete(Student s) {
        Student student = read(s);
        if (student != null){
            this.studentDB.remove(student);
            return true;
        }

        return false;
    }*/
//}
