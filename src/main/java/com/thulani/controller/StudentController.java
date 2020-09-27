package com.thulani.controller;

import com.thulani.entity.Student;
import com.thulani.factory.StudentFactory;
import com.thulani.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Thulani Kula 217026443
 * Date: 21/09/2020
 *
 * */


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/create")
    public Student create(@RequestBody Student student){
        Student student1 = StudentFactory.createStudent(student.getStudNumber(), student.getFirstName(), student.getLastName());
        return studentService.create(student1);
    }

    @GetMapping("/read/{studNumber}")
    public Student read (@PathVariable String studNumber){
        return studentService.read(studNumber);
    }

    @GetMapping("/update")
    public Student update (@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{studNumber}")
    public boolean delete(@PathVariable String studNumber){
        return studentService.delete(studNumber);
    }


}
