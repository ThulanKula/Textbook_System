package com.thulani.controller;

import java.util.Set;

import com.thulani.entity.Department;
import com.thulani.factory.DepartmentFactory;
import com.thulani.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")

public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping("/create")
    public Department create(@RequestBody Department department) {
        Department addDepartment = DepartmentFactory.createDepartment(department.getDepartmentName());

        return departmentService.create(addDepartment);
    }

    @GetMapping("/read/{departmentNum}")
    public Department read(@PathVariable String departmentNum) { return this.departmentService.read(departmentNum); }

    @PostMapping("/update")
    public Department update(@RequestBody Department department){ return this.departmentService.update(department); }

    @GetMapping("/all_department")
    public Set<Department> getAll() {
        return departmentService.getAll();
    }

    @DeleteMapping("/delete/{departmentNum}")
    public boolean delete (@PathVariable String departmentNum) {return departmentService.delete(departmentNum);}

}
