package com.thulani.repository;
/**
 *  @Author : Thulani Kula
 *  * Date : 25 August 2020
 *
 * **/
import com.thulani.entity.Year;

import java.util.Set;

public interface YearRepository extends IRepository<Year, String> {
    Set<Year> getAll();
}
