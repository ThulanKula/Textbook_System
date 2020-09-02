/**
 * This class is an entity of the course information(course number, course name) that a student is registered to
 * @author Anastasia Abrahams
 */
package entity;


public class Course {
    private String courseNum;
    private String courseName;
    
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
        private String courseNum;
        private String courseName;
        
        public Builder setCourseNum(String courseNum){
            this.courseNum = courseNum;
            return this;
        }
        public Builder setCourseName(String CourseName){
            this.courseName = courseName;
            return this;
        }
        public Course Build(){
            return new Course(this);
        }
    }//End of Builder class
}
