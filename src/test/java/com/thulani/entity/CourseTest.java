package com.thulani.entity;

import com.thulani.Util.GenericHelper;
import org.junit.Test;

public class CourseTest {
    Course.Builder builder = new Course.Builder();
    String generator = GenericHelper.generateRandomId();

    @Test
    public void buildCourse(){
        Course course1 = builder
                .setCourseCode(generator)
                .setCourseName("Accounting")
                .build();
        System.out.println(course1.toString());
    }
    @Test
    public void buildCourse2(){
        Course course1 = builder
                .setCourseCode(generator)
                .setCourseName("Multimedia")
                .build();
        System.out.println(course1.toString());
    }
}
