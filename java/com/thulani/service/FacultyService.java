package com.thulani.service.impl;

import com.thulani.entity.Faculty;
import com.thulani.service.IService;

import java.util.Set;

public interface FacultyService extends IService<Faculty, String> {
    Set<Faculty> getAll();
}
