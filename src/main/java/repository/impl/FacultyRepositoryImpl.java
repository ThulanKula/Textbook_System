package repository.impl;

import entity.Author;
import entity.Faculty;
import repository.FacultyRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Luxolo Menze
 * 217111165
 * 30 Aug 2020
 */

public class FacultyRepositoryImpl implements FacultyRepository {
    public static FacultyRepository facultyRepository = null;
    private Set<Faculty> facultyDB;

    private FacultyRepositoryImpl() {
        this.facultyDB = new HashSet<Faculty>();
    }

    public static FacultyRepository getFacultyRepository(){
        if (facultyRepository == null) facultyRepository = new FacultyRepositoryImpl();
        return facultyRepository;
    }

    public Set<Faculty> getAll()
    {
        return this.facultyDB;
    }

    public Faculty create(Faculty faculty) {
        this.facultyDB.add(faculty);
        return faculty;
    }

    public Faculty read(String ID) {
        for (Faculty faculty : this.facultyDB){
            if (faculty.getFacultyNum().equalsIgnoreCase(ID))
                return faculty;
        }
        return null;
    }
    @Override
    public Faculty update(Faculty faculty) {
        boolean deleteFaculty = delete(faculty.getFacultyNum());
        if (deleteFaculty){
            this.facultyDB.add(faculty);
            return faculty;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Faculty faculty = read(s);
        if (faculty !=  null) {
            this.facultyDB.remove(faculty);
            return true;
        }
        return false;
    }
}
