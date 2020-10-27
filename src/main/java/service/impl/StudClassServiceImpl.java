<<<<<<< Updated upstream:src/main/java/service/impl/StudClassServiceImpl.java
package service.impl;
=======
package com.thulani.service.impl;

import com.thulani.entity.StudClass;
import com.thulani.repository.StudClassRepository;
//import com.thulani.repository.impl.StudClassRepositoryImpl;
import com.thulani.service.StudClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> Stashed changes:src/main/java/com/thulani/service/impl/StudClassServiceImpl.java

import entity.StudClass;
import repository.StudClassRepository;
import repository.impl.StudClassRepositoryImpl;
import service.StudClassService;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Auhtor : Lukanyo Tando Nkohla
 * Student No. 218328877
 * **/

public class StudClassServiceImpl implements StudClassService {

    @Autowired
    private StudClassRepository repository;

<<<<<<< Updated upstream:src/main/java/service/impl/StudClassServiceImpl.java
    private StudClassServiceImpl(){
        this.repository = StudClassRepositoryImpl.studClassRepository();
    }

    public static StudClassService getService(){
        if (service == null) service = new StudClassServiceImpl();
        return service;
    }
=======
>>>>>>> Stashed changes:src/main/java/com/thulani/service/impl/StudClassServiceImpl.java

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
        if (this.repository.existsById(studClass.getStudCourseId())) {
            return this.repository.save(studClass);
        }
        return null;
     }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}
