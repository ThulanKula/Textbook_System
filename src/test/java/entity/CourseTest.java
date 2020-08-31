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
                .courseCode("9876543")
                .courseName("Information Communication Technology")
                .build();
    }
    @Test
    public void runCourseTest(){
        Course crs = build
                .courseCode("2468391")
                .courseName("BioTechnology")
                .build();
        System.out.println(crs.toString());
    }
}
