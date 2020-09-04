package entity;

/**
 *
 * @Author: Thulani Kula
 * Date: 21 June 2020
 * Desc: This class is an entity of a student which contains a student number, name (first and last) and an email address
 * which can be derived from the student number and be concatenated with a string = "@mycput.ac.za"
 *
 * */

public class Student {
    private String studNumber;
    private String firstName;
    private String lastName;
    private String email;

    private Student(Builder builder) {
        this.studNumber = builder.studNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
    }

    public String getStudNumber() {
        return studNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return studNumber+"@mycput.ac.za";
    }

    @Override
    public String toString() {
        return "Student{" +
                "studNumber='" + studNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder{

        private String studNumber;
        private String firstName;
        private String lastName;
        private String email;

        public Builder setStudNumber(String studNumber){
            this.studNumber = studNumber;
            return this;
        }

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email){
            this.email = studNumber+"@mycput.ac.za";
            return this;
        }

        public Student build(){
            return new Student(this);
        }

    } // end of Builder
} // end of Class
