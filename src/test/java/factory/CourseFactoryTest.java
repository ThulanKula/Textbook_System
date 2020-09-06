package factory;

import entity.Course;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourseFactoryTest {
    @Test
    public void equalityObject(){
        Course course1 = CourseFactory.buildCourse("Information and Communications Technology");
        Course course2 = CourseFactory.buildCourse("Mechanical Engineering");
        assertNotEquals(course1, course2);
    }
    @Test
    public void createCourse(){
        Course course = CourseFactory.buildCourse("Accounting");
        assertNotNull(course.getCourseName());
        System.out.println(course);
    }
}
