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
        Course c1 = CourseFactory.buildCourse("BIT323", "Biotechnology");
        Course c2 = CourseFactory.buildCourse("ACC253", "Accounting");
        assertNotSame(c1, c2);
    }
    
    @Test
    public void createCourse(){
        Course crs = CourseFactory.buildCourse("ICT152", "Information Communications Technology");
        assertNotNull(crs.getCourseNum());
        System.out.println(crs.getCourseNum());
        assertNotNull(crs.getCourseName());
        System.out.println(crs.getCourseName());

     }
     
}
