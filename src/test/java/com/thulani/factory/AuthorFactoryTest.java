package com.thulani.factory;

import org.junit.*;
import com.thulani.entity.Author;
import static org.junit.Assert.*;

public class AuthorFactoryTest {
    private Author author1, author2, author3;

    @Test
    public void createAuthor() {
        Author author = AuthorFactory.createAuthor("1010", "Authur C.", "Clarke");
        Assert.assertNotNull(author.getAuthFirstName());
        System.out.println(author);
    }

    @Test
    public void equalityObjectAuthor() {
        author1 = AuthorFactory.createAuthor("1010", "Authur C.", "Clarke");
        author2 = AuthorFactory.createAuthor("1010", "Authur C.", "Clarke");

        Assert.assertEquals(author1, author2);
    }

    @Test
    public void identityTest() {
        author3 = AuthorFactory.createAuthor("1010", "Authur C.", "Clarke");

        String myAuthorName = "Authur C.";
        String myAuthNumber = "1010";

        Assert.assertNotNull(author3.getAuthNumber());
        Assert.assertEquals(author3.getAuthNumber(), myAuthNumber);
        Assert.assertEquals(author3.getAuthFirstName(), myAuthorName);
    }
}