package com.thulani.repository;

import com.thulani.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
* @Author : Avery Daniels
* Date : 2020-08-30
*
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

};