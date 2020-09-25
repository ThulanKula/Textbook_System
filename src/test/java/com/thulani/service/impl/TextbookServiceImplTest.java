package com.thulani.service.impl;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 05 September 2020
 */

import com.thulani.entity.Textbook;
import com.thulani.factory.TextbookFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.thulani.service.TextbookService;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TextbookServiceImplTest {

    private static TextbookService service = TextbookServiceImpl.getService();
    private static Textbook textbook = TextbookFactory.createTextbook("Harry Potter", 12, "Brand New", "9484545", 2, 12);


    @Test
    public void a_create()
    {
        Textbook created = service.create(textbook);
        Assert.assertEquals(textbook.getBookId(), created.getBookId());
        System.out.println("Created: " +created);
    }

    @Test
    public void b_read()
    {
        Textbook read = service.read(textbook.getBookId());
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update()
    {
        Textbook updated = new Textbook.Builder().copy(textbook)
                .setBookName("Javascript for Java developers")
                .setBookISBN("983-768-8971")
                .setBookPrice(40)
                .setBookDescription("Brand new, has plastique on it!")
                .build();
        updated = service.update(updated);
        System.out.println("Updated: " +updated);
    }

    @Test
    public void f_delete()
    {
        boolean deleted = service.delete(textbook.getBookId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll()
    {
        Set<Textbook> textbooks = service.getAll();
        assertEquals(1, textbooks.size());
        System.out.println("All books: " +textbooks);
    }
}