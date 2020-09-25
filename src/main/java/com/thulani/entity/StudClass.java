package com.thulani.entity;

public class StudClass {
    private String studCourse;

    private StudClass (Builder builder){
        this.studCourse = builder.studCourse;
    }
    public String getStudCourse() {return studCourse;}

    @Override
    public String toString() {
        return "Class{" +
                "studCourse="+" "+ studCourse +
                '}';
    }
    public static class Builder {
        private String studCourse;
       // private String studCourse;

        public Builder setStudCourse(String studCourse){
            this.studCourse = studCourse;
            return this;
        }
        public StudClass Build() {return new StudClass(this);}
    }
}
