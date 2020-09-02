package service;

import entity.Year;

import java.util.Set;

public interface YearService extends IService <Year, String>{
    Set<Year> getAll();

}
