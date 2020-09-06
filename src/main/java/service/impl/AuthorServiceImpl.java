package service.impl;

import entity.Author;
import repository.AuthorRepository;
import repository.impl.AuthorRepositoryImpl;
import service.AuthorService;
import java.util.Set;

/**
 * @Author: Avery Daniels
 * Date: 2020-09-02
 */

public class AuthorServiceImpl implements AuthorService {


    public static AuthorService authorService = null;
    private AuthorRepository authorRepository;

    private AuthorServiceImpl() {
        this.authorRepository = AuthorRepositoryImpl.getAuthorRepository();
    }


    public static AuthorService getAuthorService() {
        if (authorService == null) {
            authorService = new AuthorServiceImpl();
        }
        return authorService;
    }
    @Override
    public Set<Author> getAll() {
        return this.authorRepository.getAll();
    }

    @Override
    public Author create(Author author) {

        return this.authorRepository.create(author);
    }

    @Override
    public Author read(String s) {

        return this.authorRepository.read(s);
    }

    @Override
    public Author update(Author author) {

        return this.authorRepository.update(author);
    }

    @Override
    public boolean delete(String s) {

        return this.authorRepository.delete(s);
    }
}
