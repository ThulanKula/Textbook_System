package com.thulani.repository.impl;

import com.thulani.entity.Department;
import com.thulani.repository.DepartmentRepository;

import java.util.Set;
/*
public class DepartmentRepositoryImpl implements DepartmentRepository {
    public static DepartmentRepository departmentRepository = null;
    private Set<Department> departmentDB;

    public static DepartmentRepository getDepartmentRepository() {
        if (departmentRepository == null) departmentRepository = new com.thulani.repository.impl.DepartmentRepositoryImpl();
        return departmentRepository;
    }

    @Override
    public Set<Department> getAll() {
        return this.departmentDB;
    }

    @Override
    public Department create(Department department) {
        this.departmentDB.add(department);
        return department;
    }

    @Override
    public Department read(String ID) {
        for (Department department : this.departmentDB){
            if (department.getDepartmentNum().equalsIgnoreCase(ID)) return department;
        }
        return null;
    }

    @Override
    public Department update(Department department) {
        boolean deleteDepartment = delete(department.getDepartmentNum());
        if (deleteDepartment){
            this.departmentDB.add(department);
            return department;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    /*public boolean delete(Department s) {
        Department department = read(s);
        if (department != null){
            this.departmentDB.remove(department);
            return true;
        }
        return false;*/
//}