package com.thulani.controller;

/**
 *
 * @Author: Nacisha Jaftha
 * 215194616
 * Date: 2020-09-24
 *
 */

import java.util.*;
import com.thulani.entity.Department;
import com.thulani.factory.DepartmentFactory;
import com.thulani.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Department")

public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping("/create")
    public Department create(@RequestBody Department department) {
        Department addDepartment = DepartmentFactory.createDepartment(department.getDepartmentNum(), department.getDepartmentName());

        return departmentService.create(addDepartment);
    }

    @GetMapping("/read/{departmentNum}")
    public Department read(@PathVariable String departmentNum) {
        Department readDepartment = DepartmentServiceImpl.getDepartmentService().read(departmentNum);

        return readDepartment;
    }

    @PostMapping("/update")
    public Department update(@RequestBody Department department){
        Department updateDepartment = DepartmentServiceImpl.getDepartmentService().update(department);

        return updateDepartment;
    }

    @GetMapping("/all_department")
    public Set<Department> getAll() {
        return departmentService.getAll();
    }

    @DeleteMapping("/delete/{departmentNum}")
    public boolean delete (@PathVariable String departmentNum) {return departmentService.delete(departmentNum);}

}
