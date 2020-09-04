package repository.impl;
/**
 * Author: Anastasia Abrahams
 * Date: 25 August 2020
 * CourseRepositoryImpl is a concrete class that overrides all abstract methods in IRepository and CourseRepository
 *
 */
import entity.Course;
import repository.CourseRepository;
import java.util.HashSet;
import java.util.Set;

public class CourseRepositoryImpl implements CourseRepository {
    //Data structure
    private static CourseRepository courseRepository = null;
    private Set<Course> courseDB;

    private CourseRepositoryImpl(){
        this.courseDB = new HashSet<Course>();
    }
    /**Implementing singleton so that there is only one access to the courseDB
     *
     */
    public static CourseRepository getCourseRepository(){
        if (courseRepository == null) courseRepository = new CourseRepositoryImpl();
        return courseRepository;
    }

    @Override
    public Course create(Course course) {
        this.courseDB.add(course);
        return course;
    }

    @Override
    public Course read(String id) {
        for(Course course : this.courseDB){
            if (course.getCourseNum().equalsIgnoreCase(id))
                return course;
        }
        return null;
    }

    @Override
    public Course update(Course course) {
        boolean courseDelete = delete(course.getCourseNum());
        if (courseDelete) {
            this.courseDB.add(course);
            return course;
        }
        return null;
    }

    @Override
    public boolean delete(String cNum) {
        Course course = read(cNum);
        if (course != null){
            this.courseDB.remove(course);
            return true;
        }
        return false;
    }

    @Override
    public Set<Course> getAll() {
        return this.courseDB;
    }
}
