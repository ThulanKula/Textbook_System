package com.thulani.repository;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 29 August 2020
 */

import com.thulani.entity.Textbook;

import java.util.Set;

public interface TextbookRepository extends IRepository<Textbook, String> {
    Set<Textbook> getAll();
}
