package repository;
/**
 *Author: Lukanyo Tando Nkohla
 *  Student No. 218328877
 */
import entity.StudClass;
import entity.Subject;

import java.util.Set;

public interface StudClassRepository extends IRepository<StudClass, String>{

    Set<StudClass> getAll();
}

