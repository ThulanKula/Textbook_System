package com.thulani.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthorTest {

    Author.Builder builder;

    @Before
    public void setUp() { builder = new Author.Builder(); }

    @Test
    public void correctBuild() {
        Author auth1 = builder
                .setAuthNumber("12345678")
                .setAuthFirstName("Arthur C.")
                .setAuthLastName("Clarke")
                .Build();
        System.out.println(auth1.toString());
    }

    @Test
    public void runAuthorBuild() {
        Author auth2 = builder
                .setAuthNumber("24681012")
                .setAuthFirstName("Jurgen")
                .setAuthLastName("Klopp")
                .Build();
        System.out.println(auth2.toString());
    }
}
