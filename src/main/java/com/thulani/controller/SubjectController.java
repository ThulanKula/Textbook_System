package com.thulani.controller;

import com.thulani.entity.Subject;
import com.thulani.factory.SubjectFactory;
import com.thulani.service.impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/*
 * @Author: Apiwe Xozwa
 * Date: 26 Sept 2020
 *
 */

@RestController
@RequestMapping("/Subject")
    public class SubjectController{

    @Autowired
    private SubjectServiceImpl subjectService;

    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject){
        Subject newSubject = SubjectFactory.createSubject(subject.getSubNumber(), subject.getSubName());
        return subjectService.create(newSubject);
    }

    @GetMapping("/read")
    public Subject read (@RequestBody String subject){
        Subject readSubject = SubjectServiceImpl.getService().read(subject);

        return readSubject;
    }

    @PostMapping("/update")
    public Subject update(@RequestBody Subject subject){
        Subject updateSubject = SubjectServiceImpl.getService().update(subject);

        return subject;
    }

    @GetMapping("/all_subject")
    public Set<Subject> getAll(){
        return subjectService.getAll();
    }

    @DeleteMapping("/delete")
    public boolean delete(@PathVariable String subject){
        return subjectService.delete(subject);
    }
}

