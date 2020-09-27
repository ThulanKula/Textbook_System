package com.thulani.service;

import com.thulani.entity.Author;
import java.util.Set;

/**
 * @Author: Avery Daniels
 * Date: 2020-09-02
 */

public interface AuthorService extends IService <Author, String> {
    Set<Author> getAll();
}
