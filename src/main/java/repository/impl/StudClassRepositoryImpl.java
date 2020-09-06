package repository.impl;

import entity.StudClass;
import repository.StudClassRepository;


import java.util.Set;

/***
 * @Author : Lukanyo Tando Nkohla
 * StudNo 218328877
 * */

public class StudClassRepositoryImpl implements StudClassRepository {
    public static StudClassRepository studClassRepository = null;
    private Set<StudClass> studClassDB;


    public static StudClassRepository studClassRepository() {
        if (studClassRepository == null) {
            studClassRepository = new StudClassRepositoryImpl();
        }
        return studClassRepository();
    }

    @Override
    public StudClass create(StudClass studClass) {
        this.studClassDB.add(studClass);
        return studClass;
    }

    @Override
    public StudClass read(String ID) {
        for (StudClass studClass : this.studClassDB) {
            if (studClass.getStudCourse().equalsIgnoreCase(ID))
                return studClass;
        }
        return null;
    }

    @Override
    public StudClass update(StudClass studClass) {
        boolean deleteStudClass = delete(studClass.getStudCourse());
        if (deleteStudClass) {
            this.studClassDB.add(studClass);
            return studClass;
        }
        return null;
    }

        @Override
        public boolean delete (String ID){
            StudClass studClass = read(ID);
            if (studClass != null) {
                this.studClassDB.remove(studClass);
                return true;
            }
            return false;
        }

        @Override
        public Set<StudClass> getAll () {
            return this.studClassDB;
        }
    }