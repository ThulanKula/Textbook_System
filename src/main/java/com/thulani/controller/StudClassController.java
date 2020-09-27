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
        StudClass studClass1 = studClassService.create(newstudClass);
        return studClass1;
    }

    @GetMapping("/read/{SudClass}")
    public StudClass read (@PathVariable String studCourse){
        return studClassService.read(studCourse);
    }

    @GetMapping("/update")
    public StudClass update (@RequestBody StudClass studClass){
        return studClassService.update(studClass);
    }

    @DeleteMapping("/delete/{studClasss}")
    public boolean delete(@PathVariable String studCourse){
        return studClassService.delete(studCourse);
    }
    @GetMapping("/all_StudClass")
    public Set<StudClass> getAll(){
        return studClassService.getAll();
    }

}
