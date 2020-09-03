/**
 * This is the factory class for the Course domain
 * @author Anastasia Abrahams
 */
package factory;

import entity.Course;

public class CourseFactory {
    public static Course buildCourse(String courseNum, String courseName){
        return new Course.Builder().
                setCourseNum(courseNum)
                .setCourseName(courseName)
                .build();
    }
}
