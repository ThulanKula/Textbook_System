package com.thulani.service.impl;

import com.thulani.entity.Author;
import com.thulani.repository.AuthorRepository;
import com.thulani.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: Avery Daniels
 * Date: 2020-09-02
 */

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Set<Author> getAll() { return (Set<Author>) this.authorRepository.findAll(); }

    @Override
    public Author create(Author author) { return this.authorRepository.save(author); }

    @Override
    public Author read(String s) { return this.authorRepository.findById(s).orElseGet(null); }

    @Override
    public Author update(Author author) { return this.authorRepository.save(author); }

    @Override
    public boolean delete(String s) {
        this.authorRepository.deleteById(s);
        if(this.authorRepository.existsById(s)) return false;
        else return true;
    }
}
