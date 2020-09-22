package com.thulani.factory;

import com.thulani.entity.Faculty;

public class FacultyFactory {
    public static Faculty createFaculty(String facultyNum, String facultyName){
        Faculty faculty = new Faculty.Builder().
                setFacultyNum(facultyNum).
                setFacultyName(facultyName).
                build();
        return faculty;
    }
}
