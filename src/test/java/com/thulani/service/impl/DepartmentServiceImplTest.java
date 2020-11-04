package com.thulani.service.impl;

import com.thulani.entity.Department;
import com.thulani.factory.DepartmentFactory;
import com.thulani.service.DepartmentService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DepartmentServiceImplTest {

    @Autowired
    private static DepartmentService service;
    private static Department department = DepartmentFactory.createDepartment("1101", "Applied Design");

    @Test
    public void a_create() {
        Department created = service.create(department);
        Assert.assertEquals(department.getDepartmentNum(), created.getDepartmentNum());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Department read = service.read(department.getDepartmentNum());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Department update = new Department.Builder().setDepartmentNum("3").build();
        update = service.update(update);
        System.out.println("Updated: " + update);
    }

    @Test
    public void d_delete() {
        boolean delete = service.delete(department.getDepartmentNum());
        Assert.assertTrue(delete);
    }

    @Test
    public void e_getAll() {
        Set<Department> department = service.getAll();
        assertEquals("1", department.size());
        System.out.println("Departments: " + department);
    }
}
