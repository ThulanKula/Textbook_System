package com.thulani.repository.impl;

import com.thulani.entity.Subject;
import com.thulani.entity.Textbook;
import com.thulani.repository.SubjectRepository;

import java.util.HashSet;
import java.util.Set;

/***
 * @Author : Apiwe Xozwa
 * Date : 29 August 2020
 *
 * */

/*
@Deprecated
public class SubjectRepositoryImpl implements SubjectRepository {
    public static SubjectRepository subjRepository = null;
    private Set<Subject> subjectDB;

    private SubjectRepositoryImpl()
    {
        this.subjectDB = new HashSet<Subject>();
    }

    public static SubjectRepository getSubjRepository(){
        if(subjRepository == null) {
            subjRepository = new SubjectRepositoryImpl();
        }
        return getSubjRepository();
    }

    @Override
    public Subject create(Subject subject){
        this.subjectDB.add(subject);
        return subject;
    }

    @Override
    public Subject read(String ID){
        for(Subject subject : this.subjectDB){
            if(subject.getSubNumber().equalsIgnoreCase(ID))
                return subject;
        }
        return null;
    }

    @Override
    public Subject update(Subject subject){
        boolean deleteSubject = delete(subject.getSubNumber());
        if(deleteSubject){
            this.subjectDB.add(subject);
            return subject;
        }
        return null;
    }

    @Override
    public boolean delete(String ID){
       Subject subject = read(ID);
       if(subject != null){
           this.subjectDB.remove(subject);
           return true;
       }
       return false;
    }

    @Override
    public Set<Subject> getAll(){
        return this.subjectDB;
    }

} */
