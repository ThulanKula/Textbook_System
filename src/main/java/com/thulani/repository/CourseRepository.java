package com.thulani.repository;
/**
 *Author: Anastasia Abrahams
 *  * Date 25 November 2020
 */

import com.thulani.entity.Course;

import java.util.Set;

public interface CourseRepository extends IRepository<Course, String>{
    Set<Course> getAll();
}
