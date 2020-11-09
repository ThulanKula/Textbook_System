package com.thulani.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StudClass {
    private String studCourse;

    @Id
    private String studCourseId;

    // added by me
    private StudClass(){}

    private StudClass (Builder builder){
        this.studCourse = builder.studCourse;

        // added by me
        this.studCourseId = builder.studCourseId;
    }
    public String getStudCourse() {return studCourse;}

    // added by me
    public  String getStudCourseId()
    {
        return studCourseId;
    }

    @Override
    public String toString() {
        return "Class{" +
                "studCourse="+" "+ studCourseId +
                "studCourse="+" "+ studCourse +
                '}';
    }
    public static class Builder {
        private String studCourse;
       // private String studCourse;
        // added by me
        private String studCourseId;

        public Builder setStudCourseId(String studCourseId)
        {
            this.studCourseId = studCourseId;
            return this;
        }

        public Builder setStudCourse(String studCourse){
            this.studCourse = studCourse;
            return this;
        }

        // added by me
        public Builder copy(StudClass studClass)
        {
            this.studCourseId = studClass.studCourseId;
            this.studCourse = studClass.studCourse;
            return this;
        }

        public StudClass build()
        {
            return new StudClass(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudClass studClass = (StudClass) o;
        return studCourseId.equals(studClass.studCourseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studCourseId);
    }
}
