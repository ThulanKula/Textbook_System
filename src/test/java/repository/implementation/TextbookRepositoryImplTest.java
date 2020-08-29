package repository.implementation;

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
        System.out.println("Textbook created: " +created);
    }

    @Test
    public void b_read() {
        Textbook read = textbookRepository.read(textbook.getBookId());
        System.out.println("Reading textbook created: " +read);
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
        System.out.println("Book details updated: " +updated);
    }

    @Test
    public void d_delete() {
        boolean deleted = textbookRepository.delete(textbook.getBookId());
        Assert.assertTrue(deleted);
        System.out.println("Textbook deleted!!!");
    }

    @Test
    public void e_getAll() {
        System.out.println("Get All: " +textbookRepository.getAll());
    }
}