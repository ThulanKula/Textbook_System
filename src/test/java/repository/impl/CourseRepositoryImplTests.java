package repository.impl;
/**
 * Author: Anastasia Abrahams
 * Date: 30 August 2020
 */
import entity.Course;
import factory.CourseFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.CourseRepository;
import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CourseRepositoryImplTests {
    private static CourseRepository courseRepository = CourseRepositoryImpl.getCourseRepository();
    private static Course course = CourseFactory.buildCourse("Law");

    @Test
    public void acreate(){
        Course courseCreated = courseRepository.create(course);
        assertEquals(course.getCourseCode(),courseCreated.getCourseCode());
        System.out.println("Created: " + courseCreated);
    }
    @Test
    public void bread(){
        Course read = courseRepository.read(course.getCourseCode());
        System.out.println("Read: " + read);
    }
    @Test
    public void cupdate(){
        Course updated = new Course.Builder().copy(course).courseName(" BA: Law").build();
        updated = courseRepository.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void edelete(){
        boolean delete = courseRepository.delete(course.getCourseCode());
        assertTrue(delete);
        System.out.println("Deleted");
    }
    @Test
    public void dgetAll(){
        System.out.println("All:" + courseRepository.getAll());
    }
}
