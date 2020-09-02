package service;

import entity.Author;

import java.util.Set;

public interface AuthorService extends IService <Author, String> {

    Set<Author> getAll();
}
