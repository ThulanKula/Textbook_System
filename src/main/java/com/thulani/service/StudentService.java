package com.thulani.service;

import com.thulani.entity.Student;
import java.util.Set;

/**
 * @Auhtor : Thulani Kula
 * Date: 02 Sept. 2020
 *
 * **/

public interface StudentService extends IService<Student, String> {
    Set<Student> getAll();
}
