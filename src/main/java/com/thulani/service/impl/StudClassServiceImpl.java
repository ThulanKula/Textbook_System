package com.thulani.service.impl;

import com.thulani.entity.StudClass;
import com.thulani.repository.StudClassRepository;
//import com.thulani.repository.impl.StudClassRepositoryImpl;
import com.thulani.service.StudClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Auhtor : Lukanyo Tando Nkohla
 * Student No. 218328877
 * **/
@Service
public class StudClassServiceImpl implements StudClassService {


    @Autowired
    private StudClassRepository repository;

    @Override
    public Set<StudClass> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public StudClass create(StudClass studClass) {
        return this.repository.save(studClass);
    }

    @Override
    public StudClass read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public StudClass update(StudClass studClass) {
        return this.repository.save(studClass);
    }

    @Override
    public boolean delete(String s) {
         this.repository.deleteById(s);
        if (this.repository.existsById(s)) {
            return false;
        }
        else {
            return true;
        }
    }
}