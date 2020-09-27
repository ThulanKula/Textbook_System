package com.thulani.controller;

import com.thulani.entity.StudClass;
import com.thulani.factory.StudClassFactory;
import com.thulani.service.impl.StudClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        StudClass newstudClass = StudClassFactory.createStudClass(StudClass.getStudClass());
        StudClass studClass2 = StudClassService.create(newstudClass);
        return studClass2;
    }

    @GetMapping("/read/{SudClass}")
    public StudClass read (@PathVariable String studCourse){
        return StudClassService.read(studCourse);
    }

    @GetMapping("/update")
    public StudClass update (@RequestBody StudClass studClass){
        return StudClassService.update(studClass);
    }

    @DeleteMapping("/delete/{studClasss}")
    public boolean delete(@PathVariable String studCourse){
        return StudClassService.delete(studCourse);
    }
    @GetMapping("/all_StudClasss")
    public Set<StudClass> getAll(){
        return StudClassService.getAll();
    }

}
