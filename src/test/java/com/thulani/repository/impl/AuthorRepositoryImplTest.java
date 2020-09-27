package com.thulani.repository.impl;

/*
 * @author : Avery Daniels
 * date: 2020-08-30
 */

import com.thulani.factory.AuthorFactory;
import org.junit.*;
import com.thulani.entity.Author;
import org.junit.runners.MethodSorters;
import com.thulani.repository.AuthorRepository;
import org.junit.FixMethodOrder;
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorRepositoryImplTest {

    private static AuthorRepository authorRepository = AuthorRepositoryImpl.getAuthorRepository();
    private static Author author = AuthorFactory.createAuthor("1010", "Arthur C.", "Clarke");

    @Test
    public void create() {
        Author created = authorRepository.create(author);
        Assert.assertEquals(author.getAuthNumber(), created.getAuthNumber());
        System.out.println(created);
    }

    @Test
    public void read() {
        Author read = authorRepository.read(author.getAuthNumber());
        System.out.println(read);
    }

    @Test
    public void update() {
        //List<Author> list = Arrays.asList();
        //list.add();
        Author updated = new Author.Builder().setAuthNumber("1010").setAuthFirstName("Arthur C.").setAuthLastName("Clarke").Build();
        updated = authorRepository.update(updated);
        System.out.println("updated: " +updated);
    }

    @Test
    public void delete() {
        boolean deleted = authorRepository.delete(author.getAuthNumber());
        //Assert.assertTrue(deleted);
        //System.out.println("Author Deleted");
    }

    @Test
    public void getAll() {
        System.out.println("Get All: "+authorRepository.getAll());
    }
}