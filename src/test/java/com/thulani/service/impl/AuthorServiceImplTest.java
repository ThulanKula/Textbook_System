package com.thulani.service.impl;

import com.thulani.entity.Author;
import com.thulani.factory.AuthorFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.thulani.service.AuthorService;
import java.util.Set;

/**
 * @Author: Avery Daniels
 * Date: 2020-09-02
 */

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AuthorServiceImplTest {

    private static AuthorService authorService = AuthorServiceImpl.getAuthorService();
    private static Author author = AuthorFactory.createAuthor("1010", "Arthur C.", "Clarke");

    @Test
    public void d_getAll() {
        Set<Author> author = authorService.getAll();
        assertEquals(1, author.size());
        System.out.println("All Authors: "+author);
    }

    @Test
    public void a_create() {
        Author created = authorService.create(author);
        Assert.assertEquals(author.getAuthNumber(), created.getAuthNumber());
        System.out.println(created);
    }

    @Test
    public void b_read() {
        Author read = authorService.read(author.getAuthNumber());
        System.out.println(read);
    }

    @Test
    public void c_update() {
        Author updated = new Author.Builder().setAuthNumber("1010").setAuthFirstName("Arthur C.").setAuthLastName("Clarke").Build();
        updated = authorService.update(updated);
        System.out.println("updated: " +updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = authorService.delete(author.getAuthNumber());
        Assert.assertTrue(deleted);
        System.out.println("Author Deleted");
    }
}