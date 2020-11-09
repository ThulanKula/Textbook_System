package com.thulani.repository;


import com.thulani.entity.Faculty;

import java.util.Set;

/**
 * Luxolo Menze
 * 217111165
 * 30 Aug 2020
 */

public interface FacultyRepository extends IRepository<Faculty, String> {
    Set<Faculty> getAll();
}
