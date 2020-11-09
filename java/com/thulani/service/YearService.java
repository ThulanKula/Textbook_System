package com.thulani.service;

import com.thulani.entity.Year;

import java.util.Set;

public interface YearService extends IService <Year, String>{
    Set<Year> getAll();

}
