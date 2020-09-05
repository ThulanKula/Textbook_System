package service.impl;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 05 September 2020
 */

import entity.Textbook;
import repository.TextbookRepository;
import repository.impl.TextbookRepositoryImpl;
import service.TextbookService;

import java.util.Set;

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
