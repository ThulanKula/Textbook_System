package service;

import entity.Subject;

import java.util.Set;

/**
 * @Author: Apiwe Xozwa
 * Date: 02 September 2020
 *
 */

public interface SubjectService extends IService<Subject, String>{
    Set<Subject> getAll();
}
