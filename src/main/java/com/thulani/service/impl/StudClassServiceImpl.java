package com.thulani.service.impl;

import com.thulani.entity.StudClass;
import com.thulani.repository.StudClassRepository;
import com.thulani.repository.impl.StudClassRepositoryImpl;
import com.thulani.service.StudClassService;
import java.util.Set;

/**
 * @Auhtor : Lukanyo Tando Nkohla
 * Student No. 218328877
 * **/

public class StudClassServiceImpl implements StudClassService {

    public static StudClassService service = null;
    private StudClassRepository repository;

    private StudClassServiceImpl(){
        this.repository = StudClassRepositoryImpl.studClassRepository();
    }

    public static StudClassService getService(){
        if (service == null) service = new StudClassServiceImpl();
        return service;
    }

    @Override
    public Set<StudClass> getAll() {
        return this.repository.getAll();
    }

    @Override
    public StudClass create(StudClass studClass) {
        return this.repository.create(studClass);
    }

    @Override
    public StudClass read(String s) {
        return this.repository.read(s);
    }

    @Override
    public StudClass update(StudClass studClass) {
        return this.repository.update(studClass);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
