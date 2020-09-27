package com.thulani.controller;

import com.thulani.entity.Subject;
import com.thulani.factory.SubjectFactory;
import com.thulani.service.impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * @Author: Apiwe Xozwa 214175863
 * Date: 26 Sept 2020
 */

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectService;

    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject){
        Subject newSubject = SubjectFactory.createSubject(subject.getSubNumber(), subject.getSubName());
        return subjectService.create(newSubject);
    }

    @GetMapping("/read{subjectNumber}/")
    public Subject read(@PathVariable String subjectNumber){
        return subjectService.read(subjectNumber);
    }

    @GetMapping("/update")
    public Subject update(@PathVariable Subject subject){
        return subjectService.update(subject);
    }

    @DeleteMapping("/delete/{subjectNumber}")
    public  boolean delete(@PathVariable String subjectNumber){
        return subjectService.delete(subjectNumber);
    }
}
