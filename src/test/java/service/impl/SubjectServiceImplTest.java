package service.impl;

import entity.Subject;
import factory.SubjectFactory;
import org.junit.Assert;
import org.junit.Test;
import service.SubjectService;

import javax.sound.midi.Soundbank;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SubjectServiceImplTest {

    private static SubjectService service = SubjectServiceImpl.getService();
    private static Subject subject = SubjectFactory.createSubject("310285", "Networking");

    @Test
    public void _getAll() {
        Set<Subject> subjects = service.getAll();
        assertEquals("1", subjects.size());
        System.out.println("Subjects: " + subjects);
    }

    @Test
    public void a_create() {
        Subject created = service.create(subject);
        Assert.assertEquals(subject.getSubNumber(), created.getSubNumber());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Subject read = service.read(subject.getSubNumber());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
       Subject update = new Subject.Builder().setSubNumber("20104").Build();
       update = service.update(update);
       System.out.println("Updated: " + update);
    }

    @Test
    public void d_delete() {
        boolean delete = service.delete(subject.getSubNumber());
        Assert.assertTrue(delete);
    }

}
