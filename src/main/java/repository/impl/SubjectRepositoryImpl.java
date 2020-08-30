package repository.impl;

import entity.Subject;
import repository.SubjectRepository;

import java.util.Set;

/***
 * @Author : Apiwe Xozwa
 * Date : 29 August 2020
 *
 * */

public class SubjectRepositoryImpl implements SubjectRepository {
    public static SubjectRepository subjRepository = null;
    private Set<Subject> subjectDB;


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
        return false;
    }

    @Override
    public Set<Subject> getAll(){
        return this.subjectDB;
    }

}
