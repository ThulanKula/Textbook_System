package com.thulani.service.impl;

import com.thulani.entity.Department;
import com.thulani.repository.DepartmentRepository;
import com.thulani.service.DepartmentService;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /*private DepartmentServiceImpl() {
        this.departmentRepository = DepartmentRepositoryImpl.getDepartmentRepository();
    }


    public static DepartmentService getDepartmentService() {
        if (departmentService == null) {
            departmentService = new DepartmentServiceImpl();
        }
        return departmentService;
    }*/

    @Override
    public Set<Department> getAll() {
        return this.departmentRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Department create(Department department) {

        return this.departmentRepository.save(department);
    }

    @Override
    public Department read(String s) {

        return this.departmentRepository.findById(s).orElseGet(null);
    }

    @Override
    public Department update(Department department) {

        return this.departmentRepository.save(department);
    }

    @Override
    public boolean delete(String s) {
        this.departmentRepository.deleteById(s);
        if (this.departmentRepository.existsById(s)) return false;
        else return true;
    }
}
