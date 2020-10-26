package com.thulani.controller;

import com.thulani.entity.StudClass;
import com.thulani.entity.Year;
import com.thulani.factory.StudClassFactory;
import com.thulani.service.impl.StudClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @Author : Lukanyo Tando Nkohla
 * StudNo. : 218328877
 *
 * */


@RestController
@RequestMapping("/StudClass")
public class StudClassController {

    @Autowired
    private StudClassServiceImpl studClassService;

    @PostMapping("/create")
    public StudClass create(@RequestBody StudClass studClass){
        StudClass newstudClass = StudClassFactory.createStudClass(studClass.getStudCourse());
        return studClassService.create(newstudClass);
    }

    @GetMapping("/read/{studCourseId}")
    public StudClass read (@PathVariable String studCourseId){
        return studClassService.read(studCourseId);
    }

    @GetMapping("/update")
    public StudClass update (@RequestBody StudClass studClass){
        return studClassService.update(studClass);
    }

    @DeleteMapping("/delete/{studCourseId}")
    public boolean delete(@PathVariable String studCourseId){
        return studClassService.delete(studCourseId);
    }
    @GetMapping("/all")
    public Set<StudClass> getAll(){
        return studClassService.getAll();
    }

}