package service;

import entity.Course;
import java.util.Set;

public interface CourseService extends IService<Course, String>{
    Set<Course> getAll();
}
