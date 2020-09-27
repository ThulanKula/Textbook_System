package com.thulani.repository;

import com.thulani.entity.Student;

import java.util.Set;

/**
 *  @Author : Thulani Kula
 *  * Date : 25 August 2020
 * */
public interface StudentRepository extends IRepository<Student, String>{
    Set<Student> getAll();
}
