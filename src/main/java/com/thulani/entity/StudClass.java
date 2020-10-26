package com.thulani.entity;

public class StudClass {
    private String studCourse;
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
}
