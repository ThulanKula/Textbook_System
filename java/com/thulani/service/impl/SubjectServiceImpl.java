package com.thulani.service.impl;

import com.thulani.entity.Subject;
import com.thulani.repository.SubjectRepository;
import com.thulani.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author: Apiwe Xozwa
 * Date: 02 September 2020
 *
 */

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    @Override
    public Set<Subject> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Subject create(Subject subject) {
        return this.repository.save(subject);
    }

    @Override
    public Subject read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Subject update(Subject subject) {
        if(this.repository.existsById(subject.getSubNumber()))
            return this.repository.save(subject);
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s))
            return false;
        else
            return true;
    }
}
