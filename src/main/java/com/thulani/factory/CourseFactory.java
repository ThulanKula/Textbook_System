/**
 * This is the com.thulani.factory class for the Course domain
 * @author Anastasia Abrahams
 */
package com.thulani.factory;

import com.thulani.Util.GenericHelper;
import com.thulani.Util.StringHelper;
import com.thulani.entity.Course;

public class CourseFactory {
    public static Course buildCourse(String courseName){
        if (StringHelper.isNullorEmpty(courseName))
            return  new Course.Builder().build();
        String courseId = GenericHelper.generateRandomId();
        return new Course.Builder()
                .setCourseCode(courseId)
                .setCourseName(courseName)
                .build();
    }
}
