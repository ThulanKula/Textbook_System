package com.thulani.service.impl;

import com.thulani.entity.Department;
import com.thulani.repository.DepartmentRepository;
import com.thulani.repository.impl.DepartmentRepositoryImpl;
import com.thulani.service.DepartmentService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    public static DepartmentService departmentService = null;
    private final DepartmentRepository departmentRepository;

    private DepartmentServiceImpl() {
        this.departmentRepository = DepartmentRepositoryImpl.getDepartmentRepository();
    }


    public static DepartmentService getDepartmentService() {
        if (departmentService == null) {
            departmentService = new DepartmentServiceImpl();
        }
        return departmentService;
    }
    @Override
    public Set<Department> getAll() {
        return this.departmentRepository.getAll();
    }

    @Override
    public Department create(Department department) {

        return this.departmentRepository.create(department);
    }

    @Override
    public Department read(String s) {

        return this.departmentRepository.read(s);
    }

    @Override
    public Department update(Department department) {

        return this.departmentRepository.update(department);
    }

    @Override
    public boolean delete(String s) {

        return this.departmentRepository.delete(s);
    }
}
