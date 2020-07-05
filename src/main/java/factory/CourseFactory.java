/**
 *
 * @author Anastasia Abrahams
 */
package factory;

import entity.Course;

public class CourseFactory {
    public static Course createCourse(String courseNum, String courseName){
        
        Course course = new Course.Builder().
                
            setCourseNum(courseNum)
            .setCourseName(courseName)
            .Build();
            
            return course;
    }
}
