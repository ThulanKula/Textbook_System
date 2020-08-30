package repository.impl;

import entity.Subject;
import factory.SubjectFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import repository.SubjectRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SubjectRepositoryImplTest {

    private static SubjectRepository subjectRepository = SubjectRepositoryImpl.getSubjRepository();
    private static Subject subject = SubjectFactory.createSubject("ADT256", "ADT");

    @Test
    public void getSubjectRepository() {

    }

    @Test
    public void getAll() {
        System.out.println("Get subject: " +subjectRepository.getAll());
    }

    @Test
    public void create() {
        Subject create = subjectRepository.create(subject);
        Assert.assertEquals(subject.getSubNumber(), create.getSubNumber());
        System.out.println("sub: " +subject);
    }

    @Test
    public void read() {
        Subject read = subjectRepository.read(subject.getSubNumber());
        System.out.println("Read: " +read);
    }

    @Test
    public void update() {
        Subject updating = new Subject.Builder().setSubNumber("ADT256").setSubName("ADT").Build();
        updating = subjectRepository.update(updating);
        System.out.println("update: " +updating);

    }

    @Test
    public void delete() {
        boolean del = subjectRepository.delete(subject.getSubNumber());
        Assert.assertTrue(del);
    }
}
