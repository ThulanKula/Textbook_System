package service;

import entity.StudClass;

import java.util.Set;
/**
 * @Auhtor : Lukanyo Tando Nkohla
 * Student No. 218328877
 *
 * **/
public interface StudClassService extends IService <StudClass, String>{
    Set<StudClass> getAll();

}
