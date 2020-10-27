package com.thulani.repository;

import com.thulani.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

/*
* @Author : Avery Daniels
* Date : 2020-08-30
*
 */

public interface AuthorRepository extends CrudRepository<Author, String> {};