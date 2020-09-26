package com.thulani.controller;

import com.thulani.entity.Author;
import com.thulani.factory.AuthorFactory;
import com.thulani.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author: Avery Daniels 216286182
 * Date: 2020-09-24
 *
 *
 */
@RestController
@RequestMapping("/Author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @PostMapping("/create")
    public Author create(@RequestBody Author author) {
        Author newAuthor = AuthorFactory.createAuthor(author.getAuthNumber(), author.getAuthFirstName(), author.getAuthLastName());
        Author author1 = authorService.create(newAuthor);

        return author1;
    }

    @GetMapping("/read")
    public Author read(@RequestBody String author) {
        Author readAuthor = AuthorServiceImpl.getAuthorService().read(author);

        return readAuthor;
    }

    public Author update(@RequestBody Author author){
        Author updateAuthor = AuthorServiceImpl.getAuthorService().update(author);

        return updateAuthor;
    }

    @GetMapping("/all_author")
    public Set<Author> getAll() {
        return authorService.getAll();
    }
}
