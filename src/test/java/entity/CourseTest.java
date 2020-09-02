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
                .setCourseNum("9876543")
                .setCourseName("Information Communication Technology")
                .Build();
    }
    @Test
    public void runCourseTest(){
        Course crs = build
                .setCourseNum("2468391")
                .setCourseName("BioTechnology")
                .Build();
        System.out.println(crs.toString());
    }
}
