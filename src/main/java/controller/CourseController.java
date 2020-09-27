package com.thulani.controller;

import com.thulani.entity.Course;
import com.thulani.factory.CourseFactory;
import com.thulani.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/course")

public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping
    public Course create(@RequestBody Course course){
        Course courseNew = CourseFactory.buildCourse(course.getCourseName());
        return courseService.create(courseNew);
    }

    @GetMapping("/read/{courseId}")
    public Course read (@PathVariable String courseId){
        return courseService.read(courseId);
    }

    @PostMapping("/update")
    public Course update (@RequestBody Course course){
        return courseService.update(course);
    }

    @GetMapping("/all")
    public Set<Course> getAll() {
        return courseService.getAll();
    }

    @DeleteMapping("/delete/{courseId}")
    public boolean delete(@PathVariable String courseId){
        return courseService.delete(courseId);
    }
}
