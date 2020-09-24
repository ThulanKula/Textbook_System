package com.thulani.service.impl;

import com.thulani.entity.Year;
import com.thulani.factory.YearFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.thulani.service.YearService;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class YearServiceImplTest {

    private static YearService service = YearServiceImpl.getService();
    private static Year year = YearFactory.createYear("2");

    @Test
    public void d_getAll() {
        Set<Year> years = service.getAll();
        assertEquals("1", years.size());
        System.out.println("Year: " + years);
    }

    @Test
    public void a_create() {
        Year created = service.create(year);
        Assert.assertEquals(year.getYear(), created.getYear());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Year read = service.read(year.getYear());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Year updated = new Year.Builder().setYear("3").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(year.getYear());
        Assert.assertTrue(deleted);
    }
}