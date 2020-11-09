package com.thulani.service.impl;

import com.thulani.entity.Year;
import com.thulani.repository.YearRepository;
import com.thulani.service.YearService;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Auhtor : Thulani Kula
 * Date: 02 Sept. 2020
 * Year com.thulani.service
 * **/

@Service
public class YearServiceImpl implements YearService {

    private YearRepository repository;

    @Override
    public Set<Year> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Year create(Year year) {
        return this.repository.save(year);
    }

    @Override
    public Year read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Year update(Year year) {
        return create(year);
    }

    @Override
    public boolean delete(String s) {
       this.repository.deleteById(s);
       if (this.repository.existsById(s)) return false;
       return true;
    }
}
