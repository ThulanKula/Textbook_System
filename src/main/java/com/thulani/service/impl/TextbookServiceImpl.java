package com.thulani.service.impl;

/**
 * @author aelmick
 * Des: TextbookServiceImpl.java implement business rules(CRUD) of textbook entity
 * created: 05 September 2020
 * modified: 27 oct 2020
 */

import com.thulani.entity.Textbook;
import com.thulani.repository.TextbookRepository;
import com.thulani.service.TextbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TextbookServiceImpl implements TextbookService {

    @Autowired
    private TextbookRepository repository;

    @Override
    public Set<Textbook> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Textbook create(Textbook textbook)
    {
        return this.repository.save(textbook);
    }

    @Override
    public Textbook read(String s)
    {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Textbook update(Textbook textbook)
    {
        if (this.repository.existsById(textbook.getBookId()))
        {
            return this.repository.save(textbook);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean delete(String s)
    {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
        {
            return false;
        }
        else {
            return true;
        }
    }
}
