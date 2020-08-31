/**
 *
 * @author Anastasia Abrahams
 */
package entity;
import org.junit.*;

public class CourseTest {
    Course.Builder build;
    
    @Before
    public void setUp(){
        build = new Course.Builder();
    }
    @Test
    public void correctBuild(){
        Course course = build
                .courseCode("ICT")
                .courseName("Information Communication Technology")
                .build();
        System.out.println(course.toString());
    }
    @Test
    public void runCourseTest(){
        Course crs = build
                .courseCode("BIT")
                .courseName("BioTechnology")
                .build();
        System.out.println(crs.toString());
    }
}
