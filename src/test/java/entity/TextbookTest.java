package entity;

import org.junit.Before;
import org.junit.Test;

public class TextbookTest
{
    Textbook.Builder builder;

    @Before
    public void setUp()
    {
        builder = new Textbook.Builder();
    }

    @Test
    public void rightBuild()
    {
        Textbook book1= builder
                .setBookNum(123456)
                .setBookISBN("978-3-16-148410-0")
                .setBookEdition(2020)
                .setBookName("Métriser les Maths 2")
                .setBookVolume(20)
                .setBookPrice(2000)
                .build();
        System.out.println(book1.toString());
    }

    @Test
    public void runTextbookBuild()
    {
        Textbook book2 = builder
                .setBookISBN("658-2-36-256410-0")
                .setBookName("Peter Abraham's")
                .setBookPrice(120)
                .build();

        Textbook book3 = builder
                .setBookISBN("978-2-36-256410-0")
                .setBookName("Peter Abraham's")
                .setBookPrice(170)
                .build();
        System.out.println(book2.toString());
        System.out.println(book3.toString());
    }
}