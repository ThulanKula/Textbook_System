/**
 * This class is an entity of the course information(course number, course name) that a student is registered to
 * @author Anastasia Abrahams
 */
package entity;

//Proper one
public class Course {
    private String courseCode, courseName;

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
}
