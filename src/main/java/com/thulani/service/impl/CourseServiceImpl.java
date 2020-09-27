package com.thulani.service.impl;

import com.thulani.entity.Course;
import com.thulani.repository.CourseRepository;
import com.thulani.repository.impl.CourseRepositoryImpl;
import com.thulani.service.CourseService;
import org.springframework.stereotype.Service;
/**
 * Author: Anastasia Abrahams
 * Date: 03 September 2020
 */

import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService{
    public static CourseService service = null;
    private CourseRepository cRepository;

    private CourseServiceImpl(){
        this.cRepository = CourseRepositoryImpl.getCourseRepository();
    }

    public static CourseService getCourse(){
        if(service == null) service = new CourseServiceImpl();
        return service;
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
