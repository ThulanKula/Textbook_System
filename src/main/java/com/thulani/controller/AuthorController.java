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

        return authorService.create(newAuthor);
    }

    @GetMapping("/read/{authNumber}")
    public Author read(@PathVariable String authNumber) {
        Author readAuthor = AuthorServiceImpl.getAuthorService().read(authNumber);

        return readAuthor;
    }

    @PostMapping("/update")
    public Author update(@RequestBody Author author){
        Author updateAuthor = AuthorServiceImpl.getAuthorService().update(author);

        return updateAuthor;
    }

    @GetMapping("/all_author")
    public Set<Author> getAll() {
        return authorService.getAll();
    }

    @DeleteMapping("/delete/{authNumber}")
    public boolean delete (@PathVariable String authNumber) {return authorService.delete(authNumber);}

}
