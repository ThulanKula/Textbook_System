package repository.impl;

import entity.Author;
import repository.AuthorRepository;
import java.util.*;
/*
* @Author: Avery Daniels
* Date: 2020-08-30
*
 */
public class AuthorRepositoryImpl implements AuthorRepository {
    public static AuthorRepository authorRepository = null;
    private Set <Author> authorDB;

    public static AuthorRepository getAuthorRepository() {
        if (authorRepository == null) authorRepository = new AuthorRepositoryImpl();
        return authorRepository;
    }

    @Override
    public Set<Author> getAll() {
        return this.authorDB;
    }

    @Override
    public Author create(Author author) {
        this.authorDB.add(author);
        return author;
    }

    @Override
    public Author read(String ID) {
        for (Author author : this.authorDB){
            if (author.getAuthNumber().equalsIgnoreCase(ID)) return author;
        }
        return null;
    }

    @Override
    public Author update(Author author) {
        boolean deleteAuthor = delete(author.getAuthNumber());
        if (deleteAuthor){
            this.authorDB.add(author);
            return author;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    /*public boolean delete(Author s) {
        Author author = read(s);
        if (author != null){
            this.authorDB.remove(author);
            return true;
        }
        return false;
    }*/
}
