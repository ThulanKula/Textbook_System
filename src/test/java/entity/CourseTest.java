/**
 *
 * @author Anastasia Abrahams
 */
package entity;
import org.junit.*;

public class CourseTest {
    Course.Builder build;

    @Test
    public void correctBuild(){
        Course course = build
                .setCourseNum("ICT252")
                .setCourseName("Information Communication Technology")
                .build();
        System.out.println(course.toString());
    }
    @Test
    public void runCourseTest(){
        Course crs = build
                .setCourseNum("BIT543")
                .setCourseName("BioTechnology")
                .build();
        System.out.println(crs.toString());
    }
}
