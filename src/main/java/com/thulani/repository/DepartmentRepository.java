package com.thulani.repository;

import com.thulani.entity.Department;

import java.util.Set;

public interface DepartmentRepository extends IRepository<Department, String> {
        Set<Department> getAll();
}

