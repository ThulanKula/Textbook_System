package com.thulani.repository;

import com.thulani.entity.Author;
import java.util.*;

/*
* @Author : Avery Daniels
* Date : 2020-08-30
*
 */

public interface AuthorRepository extends IRepository<Author, String>{
    Set<Author> getAll();
}
