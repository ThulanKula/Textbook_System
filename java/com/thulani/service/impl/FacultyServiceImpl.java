package com.thulani.service.impl;

import com.thulani.entity.Faculty;
import com.thulani.repository.FacultyRepository;
import com.thulani.repository.impl.FacultyRepositoryImpl;

import java.util.Set;

public class FacultyServiceImpl implements com.thulani.service.impl.FacultyService {

    private static com.thulani.service.impl.FacultyService service = null;
    private FacultyRepository repository;

    private FacultyServiceImpl(){
        this.repository = FacultyRepositoryImpl.getFacultyRepository();
    }

    public com.thulani.service.impl.FacultyService getService(){
        if(service == null) service = new FacultyServiceImpl();
        return service;
    }

    @Override
    public Set<Faculty> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Faculty create(Faculty faculty) {
        return this.repository.create(faculty);
    }

    @Override
    public Faculty read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Faculty update(Faculty faculty) {
        return this.repository.update(faculty);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
