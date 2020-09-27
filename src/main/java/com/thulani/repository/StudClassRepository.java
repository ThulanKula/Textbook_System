package com.thulani.repository;
/**
 *Author: Lukanyo Tando Nkohla
 *  Student No. 218328877
 */
import com.thulani.entity.StudClass;

import java.util.Set;

public interface StudClassRepository extends IRepository<StudClass, String>{

    Set<StudClass> getAll();
}

