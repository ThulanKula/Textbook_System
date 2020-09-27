package com.thulani.service.impl;

import com.thulani.entity.Year;
import com.thulani.repository.YearRepository;
import com.thulani.repository.impl.YearRepositoryImpl;
import com.thulani.service.YearService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Auhtor : Thulani Kula
 * Date: 02 Sept. 2020
 * Year com.thulani.service
 * **/

@Service
public class YearServiceImpl implements YearService {

    public static YearService service = null;
    private YearRepository repository;

    private YearServiceImpl(){
        this.repository = YearRepositoryImpl.getYearRepository();
    }

    public static YearService getService(){
        if (service == null) service = new YearServiceImpl();
        return service;
    }

    @Override
    public Set<Year> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Year create(Year year) {
        return this.repository.create(year);
    }

    @Override
    public Year read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Year update(Year year) {
        return this.repository.update(year);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
