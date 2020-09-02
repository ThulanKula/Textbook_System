package repository;
/**
 *Author: Anastasia Abrahams
 *  * Date 25 November 2020
 */

import entity.Course;
import java.util.Set;

public interface CourseRepository extends IRepository<Course, String>{
    Set<Course> getAll();
}
