package com.thulani.service.impl;

import com.thulani.entity.Subject;
import com.thulani.repository.SubjectRepository;
import com.thulani.repository.impl.SubjectRepositoryImpl;
import com.thulani.service.SubjectService;

import java.util.Set;

/**
 * Author: Apiwe Xozwa
 * Date: 02 September 2020
 *
 */

public class SubjectServiceImpl implements SubjectService {
    public static SubjectService service = null;
    private SubjectRepository repository;

    private SubjectServiceImpl(){
        this.repository = SubjectRepositoryImpl.getSubjRepository();
    }

    public static SubjectService getService(){
        if(service == null) service = new SubjectServiceImpl();
        return service;
    }

    @Override
    public Set<Subject> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Subject create(Subject subject) {
        return this.repository.create(subject);
    }

    @Override
    public Subject read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Subject update(Subject subject) {
        return this.repository.update(subject);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
