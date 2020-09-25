package com.thulani.factory;

import com.thulani.entity.Textbook;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextbookFactoryTest
{
    private Textbook textbook1, textbook2, textbook3;

    @Test
    public void createTextbook()
    {
        Textbook textbook = TextbookFactory.createTextbook("Introduction to programming", 2020, "Brand new book","9782362564100", 12, 1);

        Assert.assertNotNull(textbook.getBookId());
        System.out.println(textbook);
    }

    @Test
    public void equalityObjectTextbook()
    {
        textbook1 = TextbookFactory.createTextbook( "Introduction to programming", 2020,"", "8792362664100", 16, 100);
        textbook2 = TextbookFactory.createTextbook( "Introduction to programming", 2020,"" ,"8792362664100", 16, 100);

        Assert.assertNotEquals(textbook1, textbook2);
    }

    @Test
    public void identityTest()
    {
        textbook3 = TextbookFactory.createTextbook( "Introduction to programming", 2010, "","9782362564100", 52, 92);

        String myBookName = "Introduction to programming";
        String myBookISBN = "9782362564100";

        Assert.assertNotNull(textbook3.getBookISBN());
        Assert.assertEquals(textbook3.getBookISBN(), myBookISBN);
        Assert.assertEquals(textbook3.getBookName(), myBookName);

    }

}