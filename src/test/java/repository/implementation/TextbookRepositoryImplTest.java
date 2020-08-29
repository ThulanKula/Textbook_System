package repository.implementation;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 29 August 2020
 */

import entity.Textbook;
import factory.TextbookFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.TextbookRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

// Fixing Method reading to avoid complication
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TextbookRepositoryImplTest {

    private static TextbookRepository textbookRepository = TextbookRepositoryImpl.getRepository();
    private static Textbook textbook = TextbookFactory.createTextbook("Harry Potter", 12, "Brand New", "9484545", 2, 12);


    @Test
    public void a_create() {
        Textbook created = textbookRepository.create(textbook);
        Assert.assertEquals(textbook.getBookId(), created.getBookId());
        System.out.println("created: " +created);
    }

    @Test
    public void b_read() {
        Textbook read = textbookRepository.read(textbook.getBookId());
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update() {
        //List<Textbook> list = Arrays.asList();
        //list.add();
        Textbook updated = new Textbook.Builder().copy(textbook)
                .setBookName("Lord of the Rings")
                .setBookISBN("983-768-8189")
                .setBookPrice(37)
                .setBookDescription("Only used once other than that looks new")
                .build();
        updated = textbookRepository.update(updated);
        System.out.println("updated: " +updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = textbookRepository.delete(textbook.getBookId());
        Assert.assertTrue(deleted);
        //System.out.println("Textbook deleted!!!");
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All: " +textbookRepository.getAll());
    }
}