package com.thulani.service.impl;

import com.thulani.entity.Course;
import com.thulani.repository.CourseRepository;
import com.thulani.repository.impl.CourseRepositoryImpl;
import com.thulani.service.CourseService;
/**
 * Author: Anastasia Abrahams
 * Date: 03 September 2020
 */

import java.util.Set;

public class CourseServiceImpl implements CourseService{
    public static CourseService course = null;
    private CourseRepository cRepository;

    private CourseServiceImpl(){
        this.cRepository = CourseRepositoryImpl.getCourseRepository();
    }

    public static CourseService getCourse(){
        if(course == null) course = new CourseServiceImpl();
        return course;
    }

    @Override
    public Set<Course> getAll(){
        return this.cRepository.getAll();
    }

    @Override
    public Course create(Course course){

        return this.cRepository.create(course);
    }

    @Override
    public Course read(String s){

        return this.cRepository.read(s);
    }

    @Override
    public Course update(Course course){

        return this.cRepository.update(course);
    }

    @Override
    public boolean delete(String s){

        return this.cRepository.delete(s);
    }
}
