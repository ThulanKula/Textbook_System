package service.impl;

import entity.Department;
import repository.DepartmentRepository;
import repository.impl.DepartmentRepositoryImpl;
import service.DepartmentService;
import java.util.Set;

public class DepartmentServiceImpl implements DepartmentService {
    public static DepartmentService service = null;
    private DepartmentRepository repository;

    private DepartmentServiceImpl(){
        this.repository = DepartmentRepositoryImpl.getDepartmentRepository();
    }

    public static DepartmentService getService(){
        if (service == null) service = new DepartmentServiceImpl();
        return service;
    }

    @Override
    public Set<Department> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Department create(Department department) {
        return this.repository.create(department);
    }

    @Override
    public Department read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Department update(Department department) {
        return this.repository.update(department);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
