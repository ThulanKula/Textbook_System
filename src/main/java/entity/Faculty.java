package entity;

public class Faculty {
    private int facultyNum;
    private String facultyName;

    private Faculty(Builder builder){
        this.facultyName = builder.facultyName;
        this.facultyNum = builder.facultyNum;
    }

    public int getFacultyNum() {
        return facultyNum;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Faculty{" +
                "facultyNum=" + facultyNum +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
    
    public static class Builder{
        private int facultyNum;
        private String facultyName;

        public Builder setFacultyName(String facultyName){
            this.facultyName = facultyName;
            return this;
        }

        public Builder setFacultyNum(int facultyNum){
            this.facultyNum = facultyNum;
            return this;
        }

        public Faculty build(){
            return new Faculty(this);
        }


    }
}


