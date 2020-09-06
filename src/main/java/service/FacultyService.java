package service.impl;

import entity.Faculty;
import service.IService;

import java.util.Set;

public interface FacultyService extends IService<Faculty, String> {
    Set<Faculty> getAll();
}
