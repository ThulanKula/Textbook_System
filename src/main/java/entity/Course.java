/**
 * This class is an entity of the course information(course number, course name) that a student is registered to
 * @author Anastasia Abrahams
 */
package entity;


public class Course {
    private String courseNum, courseName;
    
    private Course(Builder builder){
        this.courseNum = builder.courseNum;
        this.courseName = builder.courseName;
    }

    public String getCourseNum() {
        return courseNum;
    }
    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course{" + "courseNum=" + courseNum + '\''+ ", courseName=" + courseName + '\'' + '}';
    }
    
    public static class Builder{
        private String courseNum, courseName;

        //setters that return an instance of the builder
        public Builder setCourseNum(String courseNum){
            this.courseNum = courseNum;
            return this;
        }

        public Builder setCourseName(String courseName){
            this.courseName = courseName;
            return this;
        }

        public Builder copy(Course course){
            this.courseNum = course.courseNum;
            this.courseName = course.courseName;
            return this;
        }

        public Course build(){
            return new Course(this);
        }
    }//End of Builder class
}
