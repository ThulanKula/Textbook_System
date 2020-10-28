/**
 * This class is an com.thulani.entity of the course information(course number, course name) that a student is registered to
 * @author Anastasia Abrahams
 */
package com.thulani.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Course {

    @Id
    private String courseCode;
    private String courseName;

    protected Course(){}

    private Course(Builder builder){
        this.courseCode = builder.courseCode;
        this.courseName = builder.courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course{" + "courseCode=" + courseCode + '\''+ ", courseName=" + courseName + '\'' + '}';
    }

    public static class Builder{
        private String courseCode, courseName;

        public Builder setCourseCode(String courseCode){
            this.courseCode = courseCode;
            return this;
        }
        public Builder setCourseName(String courseName){
            this.courseName = courseName;
            return this;
        }
        public Builder copy(Course course){
            this.courseCode = course.courseCode;
            this.courseName = course.courseName;
            return this;
        }
        public Course build(){
            return new Course(this);
        }
    }//End of Builder class

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseCode.equals(course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}
