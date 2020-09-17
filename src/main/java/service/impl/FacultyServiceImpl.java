package service.impl;

import entity.Faculty;
import repository.FacultyRepository;
import repository.impl.FacultyRepositoryImpl;

import java.util.Set;

public class FacultyServiceImpl implements FacultyService {

    private static FacultyService service = null;
    private FacultyRepository repository;

    private FacultyServiceImpl(){
        this.repository = FacultyRepositoryImpl.getFacultyRepository();
    }

    public FacultyService getService(){
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
