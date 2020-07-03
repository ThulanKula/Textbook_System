package factory;

import entity.Faculty;

public class FacultyFactory {
    public static Faculty createFaculty(int facultyNum, String facultyName){
        Faculty faculty = new Faculty.Builder().
                setFacultyNum(facultyNum).
                setFacultyName(facultyName).
                build();
        return faculty;
    }
}
