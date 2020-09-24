package com.thulani.service.impl;

import com.thulani.entity.Course;
import com.thulani.factory.CourseFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.thulani.service.CourseService;
import static org.junit.Assert.*;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceImplTest {
    private static CourseService service = CourseServiceImpl.getCourse();
    private static Course course = CourseFactory.buildCourse("Biomedical Science");

    @Test
    public void acreate(){
        Course created = service.create(course);
        assertEquals(course.getCourseCode(), created.getCourseCode());
        System.out.println("Created: " + created);
    }

    @Test
    public void bread(){
        Course read = service.read(course.getCourseCode());
        System.out.println("Read: " + read);
    }

    @Test
    public void cupdate(){
        Course updated = new Course.Builder().copy(course).setCourseName("Chemical Engineering").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void edelete(){
        boolean deleted = service.delete(course.getCourseCode());
        assertTrue(deleted);
    }

    @Test
    public void dgetAll(){
        Set<Course> courses = service.getAll();
        assertEquals(1, courses.size());
        System.out.println("All courses: " + courses);
    }
}