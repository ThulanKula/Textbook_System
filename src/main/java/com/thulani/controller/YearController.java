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

   @GetMapping("/read/{year}")
   public Year read (@PathVariable String year){
        return yearService.read(year);
   }

   @GetMapping("/update")
   public Year update (@RequestBody Year year){
        return yearService.update(year);
   }

   @DeleteMapping("/delete/{year}")
   public boolean delete (@PathVariable String year){
        return yearService.delete(year);
   }


    @GetMapping("/all_year")
    public Set<Year> getAll(){
        return yearService.getAll();
    }
}
