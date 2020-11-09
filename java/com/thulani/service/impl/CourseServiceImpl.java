package com.thulani.service.impl;

import com.thulani.entity.Course;
import com.thulani.repository.CourseRepository;
import com.thulani.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Author: Anastasia Abrahams
 * Date: 03 September 2020
 */

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository cRepository;

    @Override
    public Set<Course> getAll(){
        return this.cRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Course create(Course course){
        return this.cRepository.save(course);
    }

    @Override
    public Course read(String s){
        return this.cRepository.findById(s).orElseGet(null);
    }

    @Override
    public Course update(Course course){
        return create(course);
    }

    @Override
    public boolean delete(String s){
        this.cRepository.deleteById(s);
        if (this.cRepository.existsById(s)) return false;
        else return true;
    }
}
