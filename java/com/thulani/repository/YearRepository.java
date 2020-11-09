package com.thulani.repository;
/**
 *  @Author : Thulani Kula
 *  * Date : 25 August 2020
 *
 * **/
import com.thulani.entity.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface YearRepository extends JpaRepository<Year, String> {

}
