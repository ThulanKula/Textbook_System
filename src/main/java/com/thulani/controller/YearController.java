package com.thulani.controller;

import com.thulani.entity.Year;
import com.thulani.factory.YearFactory;
import com.thulani.service.impl.YearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @Author : Thulani Kula 217026443
 * Date: 21/09/2020
 *
 * */

@RestCont
@RequestMapping("/year")
public class YearController {

    @Autowired
    private YearServiceImpl yearService;

    public Year create(@RequestBody Year year){
        Year newYear = YearFactory.createYear(year.getYear());
       Year year2 = yearService.create(newYear);
        return year2;
    }

    @GetMapping("/read")
    public Year read (@RequestBody String year){
        Year readYear = YearServiceImpl.getService().read(year);
        return readYear;
    }

    public Year update(@RequestBody Year year) {
        Year updateYear = YearServiceImpl.getService().update(year);
        return updateYear;
    }



    @GetMapping("/all_year")
    public Set<Year> getAll(){
        return yearService.getAll();
    }
}
