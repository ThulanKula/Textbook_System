package com.thulani.controller;

import com.thulani.entity.Faculty;
import com.thulani.factory.FacultyFactory;
import com.thulani.service.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**Luxolo Menze
 * 217111165
 * 27 Sep 2020
 */

@RestController
@RequestMapping("/faculty")

public class FacultyController {

    @Autowired
    private FacultyServiceImpl facultyService;

    @PostMapping("/create")
    public Faculty create(@RequestBody Faculty faculty) {
        Faculty faculty1 = FacultyFactory.createFaculty(faculty.getFacultyNum(), faculty.getFacultyName());
        return faculty1;
    }

    @GetMapping("/read/{faculty}")
    public Faculty read(@PathVariable String faculty) {
        return facultyService.read(faculty);
    }

    @GetMapping("/update")
    public Faculty update(@RequestBody Faculty faculty) {
        return facultyService.update(faculty);
    }

    @DeleteMapping("/delete/{faculty}")
    public boolean delete(@PathVariable String faculty) {
        return facultyService.delete(faculty);
    }


    @GetMapping("/allFaculties")
    public Set<Faculty> getAll() {
        return facultyService.getAll();
    }
}
