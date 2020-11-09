package com.thulani.repository.impl;

import com.thulani.entity.Year;
import com.thulani.repository.YearRepository;

import java.util.HashSet;
import java.util.Set;

/***
 * @Author : Thulani Kula
 * Date : 25 August 2020
 *
 * */
/*
public class YearRepositoryImpl implements YearRepository {

    public static YearRepository yearRepository = null;
    private Set<Year>yearDB;

    private YearRepositoryImpl(){
        this.yearDB = new HashSet<Year>();
    }

    public static YearRepository getYearRepository(){
        if (yearRepository == null) yearRepository = new YearRepositoryImpl();
        return yearRepository;
    }

    public Set<Year> getAll() {
        return this.yearDB;
    }

    public Year create(Year year) {
        this.yearDB.add(year);
        return year;
    }

    public Year read(String ID) {
        for (Year year : this.yearDB){
            if (year.getYear().equalsIgnoreCase(ID)) return year;
        }
        return null;
    }
    @Override
    public Year update(Year year) {
        boolean deleteYear = delete(year.getYear());
        if (deleteYear){
            this.yearDB.add(year);
            return year;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        // it has an error if i don't have this method.
        // and it has to be String s not what i did below.
        return false;
    }

  /*  public boolean delete(Year s) {
        Year year = read(s);
        if (year != null){
            this.yearDB.remove(year);
            return true;
        }
        return false;
    }*/

//} // end of class
