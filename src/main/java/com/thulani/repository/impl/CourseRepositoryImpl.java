package com.thulani.repository.impl;
/**
 * Author: Anastasia Abrahams
 * Date: 25 August 2020
 * CourseRepositoryImpl is a concrete class that overrides all abstract methods in IRepository and CourseRepository
 *
 */
import com.thulani.entity.Course;
import com.thulani.repository.CourseRepository;
import java.util.HashSet;
import java.util.Set;

public class CourseRepositoryImpl implements CourseRepository {
    //Data structure = Set
    private Set<Course> courseDB;
    private static CourseRepository courseRepository = null;

    private CourseRepositoryImpl(){
        this.courseDB = new HashSet<>();
    }

    /**Implementing singleton so that there is only one access to the courseDB
     *
     */
    public static CourseRepository getCourseRepository(){
        if (courseRepository == null) courseRepository = new CourseRepositoryImpl();
        return courseRepository;
    }

    @Override
    public Course create(Course course) {
        this.courseDB.add(course);
        return course;
    }

    @Override
    public Course read(String id) {
        for(Course course : this.courseDB){
            if (course.getCourseCode().equalsIgnoreCase(id))
                return course;
        }
        return null;
    }

    @Override
    public Course update(Course course) {
        boolean courseDeleted = delete(course.getCourseCode());
        if (courseDeleted) {
            this.courseDB.add(course);
            return course;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Course course = read(id);
        if (course != null){
            this.courseDB.remove(course);
            return true;
        }
        return false;
    }

    @Override
    public Set<Course> getAll() {
        return this.courseDB;
    }
}
