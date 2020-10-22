package com.thulani.repository.impl;
import com.thulani.entity.StudClass;
import com.thulani.repository.StudClassRepository;


import java.util.HashSet;
import java.util.Set;

/***
 * @Author : Lukanyo Tando Nkohla
 * StudNo 218328877
 * */

public class StudClassRepositoryImpl implements StudClassRepository {

    public static StudClassRepository repository = null;
    private Set<StudClass> studClassDB;

    // Added by me
    private StudClassRepositoryImpl()
    {
        this.studClassDB = new HashSet<StudClass>();
    }

    public static StudClassRepository getRepository() {
        if (repository == null)
        {
            repository = new StudClassRepositoryImpl();
        }
        return repository;
    }

    @Override
    public StudClass create(StudClass studClass) {
        this.studClassDB.add(studClass);
        return studClass;
    }

    @Override
    public StudClass read(String ID) {
        for (StudClass studClass : this.studClassDB) {
            if (studClass.getStudCourseId().equalsIgnoreCase(ID))
                return studClass;
        }
        return null;
    }

    @Override
    public StudClass update(StudClass studClass) {
        boolean deleteStudClass = delete(studClass.getStudCourseId());
        if (deleteStudClass)
        {
            this.studClassDB.add(studClass);
            return studClass;
        }
        return null;
    }

    @Override
    public boolean delete (String ID)
    {
        StudClass studClass = read(ID);
        if (studClass != null)
        {
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