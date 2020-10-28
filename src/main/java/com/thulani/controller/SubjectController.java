package com.thulani.controller;

import com.thulani.entity.Subject;
import com.thulani.factory.SubjectFactory;
import com.thulani.service.impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @PostMapping("/update")
    public Subject update(@RequestBody Subject subject){
        return subjectService.update(subject);
    }

    @DeleteMapping("/delete/{subjectNumber}")
    public  boolean delete(@PathVariable String subjectNumber){
        return subjectService.delete(subjectNumber);
    }

    @GetMapping("/all")
    public Set<Subject> getall(){return subjectService.getAll();}

}
