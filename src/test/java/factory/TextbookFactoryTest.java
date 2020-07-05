package factory;

import entity.Textbook;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextbookFactoryTest
{
    private Textbook textbook, textbook1, textbook2, textbook3;

    @Test
    public void createTextbook()
    {
        textbook = TextbookFactory.createTextbook(1, "Introduction to programming", 2020, "9782362564100", 12, 212);

        Assert.assertNotNull(textbook.getBookName());
        Assert.assertNotNull(textbook.getBookISBN());
        Assert.assertEquals(1, textbook.getBookNum());
        Assert.assertEquals(212, textbook.getBookPrice(), 0);
        Assert.assertEquals(12, textbook.getBookVolume());


    }

    @Test
    public void equalityObjectTextbook()
    {
        textbook1 = TextbookFactory.createTextbook(2, "Introduction to programming", 2020, "8792362664100", 16, 100);
        textbook2 = TextbookFactory.createTextbook(3, "Introduction to programming", 2020, "8792362664100", 16, 100);

        Assert.assertNotEquals(textbook1, textbook2);
    }

    @Test
    public void identityTest()
    {
        textbook3 = TextbookFactory.createTextbook(14, "Introduction to programming", 2010, "9782362564100", 52, 92);

        String myBookName = "Introduction to programming";
        String myBookISBN = "9782362564100";

        Assert.assertNotNull(textbook3.getBookISBN());
        Assert.assertEquals(textbook3.getBookISBN(), myBookISBN);
        Assert.assertEquals(textbook3.getBookName(), myBookName);

    }

}