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
        Course c1 = CourseFactory.createCourse("3487569", "Biotechnology");
        Course c2 = CourseFactory.createCourse("6766436", "Accounting");
        
        assertNotSame(c1, c2);
    }
    
    @Test
    public void createCourse(){
        Course crs = CourseFactory.createCourse("1234567", "Information Communications Technology");
        
        assertNotNull(crs.getCourseNum());
        assertNotNull(crs.getCourseName());
     }
     
}
