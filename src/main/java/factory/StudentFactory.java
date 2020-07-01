package factory;

import entity.Student;
/**
 * @Author: Thulani Kula
 * Date: 01 July 2020
 * Desc: This is a factory class for the student domain.
 *
 * */
public class StudentFactory {
    public static Student createStudent (String studNumber, String firstName, String lastName){
        String email = studNumber+"@mycput.ac.za";

        Student student = new Student.Builder().
                setStudNumber(studNumber).
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(email).Build();

        return student;
    } // end of method
}// end of class
