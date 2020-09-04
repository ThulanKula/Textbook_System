package repository.impl;
/**
 * Author: Anastasia Abrahams
 * Date: 30 August 2020
 */
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.CourseRepository;
import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CourseRepositoryImplTests {
    private static CourseRepository courseRepository = CourseRepositoryImpl.getCourseRepository();
    private static Course course = CourseFactory.buildCourse("LLB252", "Law");

    @Test
    public void acreate(){
        Course courseCreated = courseRepository.create(course);
        assertEquals(course.getCourseNum(),courseCreated.getCourseNum());
        System.out.println("Created: " + courseCreated);
    }
    @Test
    public void bread(){
        Course read = courseRepository.read(course.getCourseNum());
        System.out.println("Read: " + read);
    }
    @Test
    public void cupdate(){
        Course updatedCourse = new Course.Builder().copy(course).setCourseNum("MCE135").setCourseName("Mechanical Engineering").build();
        updatedCourse = courseRepository.update(updatedCourse);
        System.out.println("Updated: " + updatedCourse);
    }
    @Test
    public void edelete(){
        boolean delete = courseRepository.delete(course.getCourseNum());
        assertTrue(delete);
        System.out.println("Deleted: " + delete);
    }
    @Test
    public void dgetAll(){
        System.out.println("All:" + courseRepository.getAll());
    }
}
