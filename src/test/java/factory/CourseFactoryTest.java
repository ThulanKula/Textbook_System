/**
 * This is the test class for course factory 
 * @author Anastasia Abrahams
 */
package factory;

import entity.Course;
import org.junit.*;
import static org.junit.Assert.*;

public class CourseFactoryTest {
    
    @Test
    public void objectEquality(){
        Course c1 = CourseFactory.buildCourse("Biotechnology");
        Course c2 = CourseFactory.buildCourse("Accounting");
        assertNotSame(c1, c2);
        System.out.println(c1);
        System.out.println(c2);
    }
    
    @Test
    public void createCourse(){
        Course crs = CourseFactory.buildCourse("Information and Communications Technology");
        
        assertNotNull(crs.getCourseCode());
        assertNotNull(crs.getCourseName());
        System.out.println("Code: " + crs.getCourseCode());
        System.out.println("Name: " + crs.getCourseName());
    }
     
}
