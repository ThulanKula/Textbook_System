package com.thulani.service.impl;

import com.thulani.entity.Year;
import com.thulani.factory.YearFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.thulani.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class YearServiceImplTest {

    @Autowired
    private static YearService service;
    private static Year year = YearFactory.createYear("2");

    @Test
    public void d_getAll() {
        Set<Year> years = service.getAll();
        assertNotNull(years);
    }

    @Test
    public void a_create() {
        Year created = service.create(year);
        assertEquals(year.getYear(), created.getYear());
    }

    @Test
    public void b_read() {
        Year read = service.read(year.getYear());
        assertNotNull(read);
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