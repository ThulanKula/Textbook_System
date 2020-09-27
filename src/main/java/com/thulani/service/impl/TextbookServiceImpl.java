package com.thulani.service.impl;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 05 September 2020
 */

import com.thulani.entity.Textbook;
import com.thulani.repository.TextbookRepository;
import com.thulani.repository.impl.TextbookRepositoryImpl;
import com.thulani.service.TextbookService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TextbookServiceImpl implements TextbookService {

    private  static TextbookService service = null;
    private TextbookRepository repository;

    private TextbookServiceImpl()
    {
        this.repository = TextbookRepositoryImpl.getRepository();
    }

    public static TextbookService getService()
    {
        if (service == null)
        {
            service = new TextbookServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Textbook> getAll()
    {
        return this.repository.getAll();
    }

    @Override
    public Textbook create(Textbook textbook)
    {
        return this.repository.create(textbook);
    }

    @Override
    public Textbook read(String s)
    {
        return this.repository.read(s);
    }

    @Override
    public Textbook update(Textbook textbook)
    {
        return this.repository.update(textbook);
    }

    @Override
    public boolean delete(String s)
    {
        return this.repository.delete(s);
    }
}
