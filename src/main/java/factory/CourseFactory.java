/**
 * This is the factory class for the Course domain
 * @author Anastasia Abrahams
 */
package factory;

import Util.GenericHelper;
import Util.StringHelper;
import entity.Course;

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
