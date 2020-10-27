package com.thulani.repository;

/**
 * @author aelmick
 * Des: StringHelper class
 * date: 29 August 2020
 */

import com.thulani.entity.Textbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextbookRepository extends JpaRepository<Textbook, String> {

}
